package org.remotecontrol4j.server.util;

/**
 * 判断当前操作系统类型
 * @author and4walker
 *
 */
public class OS
{
	 public static boolean isWindows(){
	  if (System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1) {
	   return true;
	  }
	  return false;
	 }

}
