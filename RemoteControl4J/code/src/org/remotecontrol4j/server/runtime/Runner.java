package org.remotecontrol4j.server.runtime;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.remotecontrol4j.server.meta.Entity;

/**
 * 根据手工配置自动运行
 * 
 * @author and4walker
 *
 */
public abstract class Runner
{
	
	public abstract void run();
	
	public Object autoSelect(Entity entity,Class<?>... classes) throws InterruptedException, ExecutionException {		
		if(null == entity){
			return null;
		}
		
		for(Class clazz : classes){
			
			
			
		}
		
		
		if(entity.isMultiThread()){
			runMulti(entity);
		}else{
			runSingle();
		}
		return classes;
		
	}
	
	
	private Object runSingle(){
		return null;
		
	}
	
	private Object runMulti(Entity entity) throws InterruptedException, ExecutionException{
		ExecutorService pool = Executors.newFixedThreadPool(entity.getThreadCount());
		
		Callable<Object> task = new Callable<Object>(){
			public Object call() throws Exception {
				Object result = "";
				return result;
			}
		};
		
		Future<Object> future = pool.submit(task);
		Object obj = future.get();
		return obj;
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException{
		Class<?> clazz = Class.forName("org.remotecontrol4j.server.plugin.StartUp");
		Class<?>[] inter = clazz.getInterfaces();
		System.out.println(inter[0].getName());
	}
	
	
	
}
