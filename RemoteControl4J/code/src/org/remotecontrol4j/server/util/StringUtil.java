package org.remotecontrol4j.server.util;

/**
 * 字符串处理工具类
 * 
 * @author and4walker
 * 
 */
public class StringUtil
{
	/**
	 * 判断是否为空或空格
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNullOrBlank(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}
	
	
}
