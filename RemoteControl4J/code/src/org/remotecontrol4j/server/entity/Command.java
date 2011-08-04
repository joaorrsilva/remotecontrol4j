package org.remotecontrol4j.server.entity;

import org.remotecontrol4j.server.runtime.Executor;

/**
 * 命令实体类
 * 
 * @author and4walker
 *
 */
public class Command
{
	/** 可执行的命令  **/
	protected Executor executor;
	
	/** 是否为多线程执行 **/
	protected boolean isMultiThread = false;
	
	/** 线程,默认个数为10 **/
	protected int threadCount = 10;
	

	public boolean isMultiThread() {
		return isMultiThread;
	}

	public void setMultiThread(boolean isMultiThread) {
		this.isMultiThread = isMultiThread;
	}

	public int getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
	}

	public Executor getExecutor() {
		return executor;
	}

	public void setExecutor(Executor executor) {
		this.executor = executor;
	}

}
