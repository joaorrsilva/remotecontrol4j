package org.remotecontrol4j.server.plugin;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.remotecontrol4j.server.runtime.Container;
import org.remotecontrol4j.server.runtime.Executor;


/**
 * 利用InetAddress的isReachable方法实现 <br>
 * 非ICMP的ping工具 <br>
 * 
 * @author and4walker
 *
 */
public class Ping implements Container{

	private static final char TIME_OUT = 3000;
	
	public static boolean send(String ip) {
		try {
      InetAddress address = InetAddress.getByName(ip);
      return address.isReachable(TIME_OUT);
	  } catch (UnknownHostException e) {
	      e.printStackTrace();
	  } catch (IOException e) {
	      e.printStackTrace();
	  } 
		return false;
	}

	@Override
	public String load() {
		return Executor.ping.getPrototype();
	}
  
	
	
}
