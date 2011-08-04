package org.remotecontrol4j.server.runtime;

/**
 * 根据操作系统类型判断
 * 加载相应的命令
 * 
 * @author and4walker
 *
 */
public class Selector
{
	/** 是否为windows系统 **/
	public static OS SYSTEM;
	
	static{
		if (System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1) {
			SYSTEM = OS.WINDOWS;
		}
		SYSTEM = OS.UNIX;
	}
	
}
