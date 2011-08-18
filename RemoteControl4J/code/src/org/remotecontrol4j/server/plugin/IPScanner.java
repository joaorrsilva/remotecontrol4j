package org.remotecontrol4j.server.plugin;

import org.remotecontrol4j.server.meta.Result;
import org.remotecontrol4j.server.meta.Task;
import org.remotecontrol4j.server.runtime.Executor;
import org.remotecontrol4j.server.runtime.InitPool;
import org.remotecontrol4j.server.runtime.Launcher;
import org.remotecontrol4j.server.runtime.OS;
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
	public Result execute() throws Exception {	
		String ip = (String)this.params[0]+(this.taskId+1);
		boolean flag = Ping.send(ip);
		if(flag){
			Launcher.run(InitPool.CMD_MAP.get(Executor.ping_key)+StringUtil.BLANK+ip);
			String msg = Launcher.run(InitPool.CMD_MAP.get(Executor.arp_key)+StringUtil.BLANK+ip);
			System.out.println(msg);
			Result result = new Result();
			result.setValue(OS.TYPE==OS.WINDOWS?msg.split(" ")[32]:msg.split(" ")[32]);//mac address
			return result;
		}
		return new Result();
	}

}
