package org.remotecontrol4j.server.runtime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import org.remotecontrol4j.server.meta.Host;
import org.remotecontrol4j.server.meta.Result;
import org.remotecontrol4j.server.plugin.IPScanner;
import org.remotecontrol4j.server.util.StringUtil;

public class TestTaskRouter
{
	
	public static String getMac() throws Exception{
		Launcher.run("ping 192.168.0.1");
		String msg = Launcher.run("arp -a  192.168.0.1");
		String mac = msg.split(" ")[32];
		return mac;
	}

	public static void main(String[] args) throws Exception{ 
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(new Date()));
		

		Host host = new Host();
		host.setIp("192.168.3.176");
		String preIP = StringUtil.getPreIPV4(host.getIp());
		host.setPreIp(preIP);
		TaskRouter.run(IPScanner.class, 255, 200, host);
		
		while(Result.resultMap.size() != 255){
			Thread.sleep(1000);
		}
		
		for(Integer key : Result.resultMap.keySet()){
			Object value = Result.resultMap.get(key).getValue();
			if(null == value){
				continue;
			}
			Host ho = (Host)value; 
			System.out.println(ho.getIp()+"active mac:"+ho.getName() );
		}
		System.out.println(format.format(new Date()));
		
		
	}
	
}
