package org.remotecontrol4j.server.plugin;

import org.remotecontrol4j.server.meta.Host;

public class TestStartup
{

	public static void main(String[] args){
		String mac = "" ;
		Host host = new Host(mac,"",9);
		Startup startup = new Startup();
		startup.send(host);
	}
}
