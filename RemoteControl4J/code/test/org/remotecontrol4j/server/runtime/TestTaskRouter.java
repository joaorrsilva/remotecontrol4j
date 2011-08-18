package org.remotecontrol4j.server.runtime;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.remotecontrol4j.server.meta.Host;
import org.remotecontrol4j.server.meta.Result;
import org.remotecontrol4j.server.plugin.IPScanner;
import org.remotecontrol4j.server.util.StringUtil;

public class TestTaskRouter
{

	public static void main(String[] args) throws Exception{ 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(new Date()));
		
		
		Host host = new Host();
		host.setIp("192.168.0.4");
		String preIP = StringUtil.getPreIPV4(host.getIp());

		Result result = TaskRouter.run(IPScanner.class, 255, 5, preIP);
		
		
		for(Integer key : result.getResultMap().keySet()){
			Object value = result.getResultMap().get(key).getValue();
			if(null == value){
				continue;
			}
			System.out.println("active ip:"+value.toString());
		}
		System.out.println(format.format(new Date()));
		
		
	}
	
}
