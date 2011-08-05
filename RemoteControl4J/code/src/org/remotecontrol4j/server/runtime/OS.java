package org.remotecontrol4j.server.runtime;

/**
 * 操作系统类型
 *  
 * @author and4walker
 *
 */
public enum OS
{
	WINDOWS,
	UNIX;
	
	/** 默认为Windows **/
	public static OS type = WINDOWS;
	
	/**
	 * 判断当前系统类型
	 * @return
	 */
	public static void initCurrentOS(){
		if (System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1) {
			type = OS.WINDOWS;
		}
		type = OS.UNIX;
	}
}
