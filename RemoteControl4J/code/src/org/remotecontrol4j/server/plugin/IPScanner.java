package org.remotecontrol4j.server.plugin;

import java.util.List;

import org.remotecontrol4j.server.meta.Host;
import org.remotecontrol4j.server.meta.Result;
import org.remotecontrol4j.server.meta.Task;
import org.remotecontrol4j.server.util.StringUtil;

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
		String ip = (String)this.params[0]+(this.taskId+1);
		boolean flag = Ping.send(ip);
		if(flag){
			Result result = new Result();
			result.setValue(ip);
			return result;
		}
		return new Result();
	}
 

	
	


}
