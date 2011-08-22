package org.remotecontrol4j.server.plugin;

import java.util.concurrent.ConcurrentHashMap;

import org.remotecontrol4j.server.meta.Host;
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
	public void execute() throws Exception {	
		Host host = (Host)this.params[0];
		if(host == null){
			return;
		}
		String ip = host.getPreIp() + (this.taskId+1);
			//根据arp 获取 mac地址，跨OS，但是有时候arp为空
//			Launcher.run(InitPool.CMD_MAP.get(Executor.ping_key)+StringUtil.BLANK+ip);
//			String msg = Launcher.run(InitPool.CMD_MAP.get(Executor.arp_key)+StringUtil.BLANK+ip);			
//			Result result = new Result();
//			if(Arp.isNotNull(msg)){//arp cache不为空.mac地址就不为空
//				result.setValue(OS.TYPE==OS.WINDOWS?msg.split(" ")[32]:msg.split(" ")[32]);//mac address
//			}
//			return result;
			
		//如果是windows系统扫描windows系统，可以根据nbtstat获取计算机名等
		//String msg = Launcher.run(InitPool.CMD_MAP.get(Executor.nbtstat_key)+StringUtil.BLANK+ip);
		//Host host = Nbtstat.getHost(msg);
		
		Result result = new Result();
		Host newHost = Ping.getHost(ip);
		result.setValue(newHost);			
		Result.resultMap.put(this.taskId, result);
		if(null != newHost){
			System.out.println("ip="+newHost.getIp()+" isonline="+newHost.isOnline()+" name="+newHost.getName()+" groupName="+newHost.getGroupName()+" mac="+newHost.getMac());
		}
	}

}
