package org.remotecontrol4j.server.runtime;

import org.remotecontrol4j.server.meta.Host;

/**
 * 自实现命令发送器
 * 
 * @author and4walker
 *
 */
public interface Launcher
{
	/**
	 * 发送成功返回true
	 * 发送失败返回false
	 * @return
	 */
	boolean send(Host host);
	
}
