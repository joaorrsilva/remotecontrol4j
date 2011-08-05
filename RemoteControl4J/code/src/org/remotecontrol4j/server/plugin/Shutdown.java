package org.remotecontrol4j.server.plugin;

import org.remotecontrol4j.server.meta.Command;
import org.remotecontrol4j.server.runtime.Container;
import org.remotecontrol4j.server.runtime.Executor;
import org.remotecontrol4j.server.runtime.OS;

/**
 * 远程关机 <br>
 * 
 * 目前还没有太好的实现，调用系统命令实现 <br>
 * 
 * @author and4walker
 *
 */
public class ShutDown implements Container
{

	public Command load() {	
		Command cmd = new Command();
		cmd.setMultiThread(true);
		cmd.setThreadCount(10);
		switch(OS.type){
		case WINDOWS:
			cmd.setExecutor(Executor.win_shutdown);
			break;
		case UNIX:
			cmd.setExecutor(Executor.unix_shutdown);
			break;
		}
		return cmd;
	}
	
}
