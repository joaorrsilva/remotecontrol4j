package org.remotecontrol4j.server.entity;

import java.util.List;

/**
 * 命令实体类
 * 
 * @author and4walker
 *
 */
public class Command
{
	/** 命令名称  **/
	private String name;
	
	/** 命令参数列表 **/
	private List<String> params;
	
	/** 是否为多线程执行 **/
	private boolean isMultiThread = false;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}

	public boolean isMultiThread() {
		return isMultiThread;
	}

	public void setMultiThread(boolean isMultiThread) {
		this.isMultiThread = isMultiThread;
	}
	
}
