package org.remotecontrol4j.server.runtime;

/**
 * 可执行命令集
 * 
 * @author and4walker
 *
 */
public enum Executor
{
	shutdown_key,
	restart_key,
	arp_key,
	
	win_shutdown("shutdown "),
	win_restart("shutdown "),
	win_arp("arp -a"),
	
	unix_shutdown("shutdown"),
	unix_restart("shutdown"),
	unix_arp("arp");
	
	/** 命令原型 **/
  private String prototype;
	
  Executor(){
  	
  }
  
	Executor(String prototype){
		this.prototype = prototype;
	}
	
	public String getPrototype() {
		return prototype;
	}

	public void setPrototype(String prototype) {
		this.prototype = prototype;
	}
	
}
