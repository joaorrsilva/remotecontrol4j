package org.remotecontrol4j.server.runtime;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.remotecontrol4j.server.meta.Result;
import org.remotecontrol4j.server.meta.Task;

/**
 * 任务路由器 <br>
 * 
 * @author and4walker
 *
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class TaskRouter
{
	
	private static final int THREAD_POOL = 10;
	
	public static <P extends Object> Result run(Class<? extends Task> clazz,int taskCount,int threadCount,P... params) throws Exception{
		if(1 < threadCount){
			return runMulti(clazz,taskCount,threadCount,params);
		}
		return runSingle(clazz,taskCount,params);
	}
	
	private static <P extends Object> Result runSingle(Class<? extends Task> clazz,int taskCount,P... params) throws Exception{
		List<Task> taskList = getTaskList(clazz,taskCount,params);
		Result result = new Result();
		for(Task task : taskList){
			result.getResultMap().put(task.getTaskId(), task.execute());
		}
		return result;
	}
	
	private static <P extends Object> Result runMulti(Class<? extends Task> clazz,int taskCount,int threadCount,P... params) throws Exception {		
		List<Task> taskList = getTaskList(clazz,taskCount,params);
		Result result = new Result();
		List<Task>[] taskListPerThread = TaskRouter.distribute(taskList, threadCount);
		ExecutorService pool = Executors.newFixedThreadPool(THREAD_POOL);
		for (int i = 0; i < taskListPerThread.length; i++) {
				Callable<Result> workThread = new TaskWorker(i, taskListPerThread[i]);
				Future<Result> future = pool.submit(workThread);
				ConcurrentHashMap<Integer,Result> taskResultMap = future.get().getResultMap();
				for(Integer key : taskResultMap.keySet()){
					result.getResultMap().put(key, taskResultMap.get(key));
				}
		}
		pool.shutdown();
		return result;
	}
	
	/**
	 * 通过反射获取其构造方法并构建任务列表
	 * @param clazz
	 * @param taskCount
	 * @return
	 * @throws Exception
	 */
	private static <P extends Object> List<Task> getTaskList(Class<? extends Task> clazz,int taskCount,P... params) throws Exception{
		Constructor<Task> constructor =  (Constructor<Task>) clazz.getConstructors()[0];
		List<Task> taskList = new ArrayList<Task>();
		for (int i = 0; i < taskCount; i++) {
			taskList.add(constructor.newInstance(i,params));
		}
		return taskList;
	}
	
	/**
	 * 把 List 中的任务平均分配给每个线程，剩于的依次附加给前面的线程 
	 * 返回的数组有多少个元素 (List) 就表明将启动多少个工作线程
	 * 
	 * @param taskList
	 * @param threadCount
	 * @return 
	 */
	private static List<Task>[] distribute(List<Task> taskList, int threadCount) {
		int minTaskCount = taskList.size() / threadCount;
		int remainTaskCount = taskList.size() % threadCount;
		int actualThreadCount = minTaskCount > 0 ? threadCount : remainTaskCount;
		List<Task>[] taskListPerThread = new List[actualThreadCount];
		int taskIndex = 0;
		int remainIndces = remainTaskCount;
		for (int i = 0; i < taskListPerThread.length; i++) {
			taskListPerThread[i] = new ArrayList<Task>();
			if (minTaskCount > 0) {
				for (int j = taskIndex; j < minTaskCount + taskIndex; j++) {
					taskListPerThread[i].add(taskList.get(j));
				}
				taskIndex += minTaskCount;
			}
			if (remainIndces > 0) {
				taskListPerThread[i].add(taskList.get(taskIndex++));
				remainIndces--;
			}
		}
		return taskListPerThread;
	}
}
