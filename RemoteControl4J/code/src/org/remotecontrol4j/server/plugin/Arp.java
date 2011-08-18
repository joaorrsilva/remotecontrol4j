package org.remotecontrol4j.server.plugin;

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

	public String load() {
		String cmd = null;
		switch(OS.TYPE){
		case WINDOWS:
			cmd = Executor.win_arp.getPrototype();
			break;
		case UNIX:
			cmd = Executor.unix_arp.getPrototype();
			break;
		}
		return cmd;
	}

}
