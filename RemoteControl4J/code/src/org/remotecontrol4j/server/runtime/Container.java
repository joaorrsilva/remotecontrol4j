package org.remotecontrol4j.server.runtime;

import org.remotecontrol4j.server.entity.Command;

/**
 * Windows、Unix系统命令装载器
 * 
 * @author and4walker
 *
 */
public interface Container
{
	/**
	 * 装载命令
	 * @return
	 */
	Command load();
	
}
