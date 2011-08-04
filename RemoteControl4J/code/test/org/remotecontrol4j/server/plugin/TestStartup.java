package org.remotecontrol4j.server.plugin;

import org.remotecontrol4j.server.entity.Host;

public class TestStartup
{

	public static void main(String[] args){
		String mac = "" ;
		Host host = new Host(mac,"",9);
		StartUp startup = new StartUp();
		startup.sendMessage(host);
	}
}
