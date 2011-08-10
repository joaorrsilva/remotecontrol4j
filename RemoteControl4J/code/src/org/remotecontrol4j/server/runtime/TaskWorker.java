package org.remotecontrol4j.server.runtime;

import java.util.List;
import java.util.concurrent.Callable;

import org.remotecontrol4j.server.meta.Result;
import org.remotecontrol4j.server.meta.Task;

/**
 * 任务运行器
 * 
 * @author and4walker
 * @param <T>
 *
 */
@SuppressWarnings("rawtypes")
public class TaskWorker implements Callable<Result>
{
	private List<Task> taskList;
	private int threadId;
	private Result result;
	
	public TaskWorker(int threadId,List<Task> taskList){
		this.threadId = threadId;
		this.taskList = taskList;
		this.result = new Result();
	}

	@Override
	public Result call() throws Exception {
		for(Task task : taskList){
			this.result.getResultMap().put(task.getTaskId(), task.execute());
		}
		return result;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public int getThreadId() {
		return threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}
