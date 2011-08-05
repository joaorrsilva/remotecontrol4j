package org.remotecontrol4j.server.plugin;

import org.remotecontrol4j.server.meta.Command;
import org.remotecontrol4j.server.runtime.Container;
import org.remotecontrol4j.server.runtime.Executor;
import org.remotecontrol4j.server.runtime.OS;

/**
 * ARP工具 <br>
 * 
 * @author and4walker
 *
 */
public class Arp implements Container
{

	public Command load() {
		Command cmd = new Command();
		cmd.setMultiThread(true);
		cmd.setThreadCount(10);
		switch(OS.type){
		case WINDOWS:
			cmd.setExecutor(Executor.win_arp);
			break;
		case UNIX:
			cmd.setExecutor(Executor.unix_arp);
			break;
		}
		return cmd;
	}

}
