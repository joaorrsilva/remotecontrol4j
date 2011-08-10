package org.remotecontrol4j.server.plugin;

import org.remotecontrol4j.server.meta.Result;
import org.remotecontrol4j.server.meta.Task;

/**
 * IP扫描器 <br>
 * 
 * @author and4walker
 * @param <T>
 *
 */
public class IPScanner<P> extends Task<P>
{	

	public IPScanner(int taskId, P... params)
	{
		super(taskId, params);
		this.taskId = taskId;
		this.params = params;
	}

	@Override
	public Result execute() {	
		String ip = this.params[0].toString() + (taskId+1);
		System.out.println(Thread.currentThread().getName()+"   "+ip);
		return new Result();
	}


	
	


}
