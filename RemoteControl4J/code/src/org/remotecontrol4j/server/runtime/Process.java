package org.remotecontrol4j.server.runtime;

import java.util.EnumMap;

import org.remotecontrol4j.server.entity.Command;
import org.remotecontrol4j.server.plugin.Arp;
import org.remotecontrol4j.server.plugin.Restart;
import org.remotecontrol4j.server.plugin.ShutDown;

/**
 * 调用系统进程执行命令 <br>
 * 
 * @author and4walker
 *
 */
public class Process {
	
	public static EnumMap<Executor,Command> CMD_MAP = new EnumMap<Executor,Command>(Executor.class);
	
	/**
	 * 启动本程式时自动加载初始化操作<br>
	 */
	static{
		initOrder();
	}
	
	/**
	 * 进程初始化操作  <br>
	 * 将本类型OS的命令全部加载到内存中 <br>
	 */
	private static void initOrder(){		
		CMD_MAP.put(Executor.shutdown_key, new ShutDown().load());
		CMD_MAP.put(Executor.restart_key, new Restart().load());
		CMD_MAP.put(Executor.arp_key, new Arp().load());
	}
	
}

