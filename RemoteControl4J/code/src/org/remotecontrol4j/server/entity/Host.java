package org.remotecontrol4j.server.entity;

/**
 * 远程计算机实体类
 * @author and4walker
 *
 */
public class Host
{

  /** mac地址 **/
  private String mac;
  /** 内网广播域或者公网IP地址 **/
  private String ip;
  /** 端口号 **/
  private int port;
  
  public Host(){
  	
  }

  public Host(String mac,String ip,int port){
  	this.mac = mac;
  	this.ip = ip;
  	this.port = port;
  }
  
  public String getMac()
  {
    return mac;
  }

  public void setMac(String mac)
  {
    this.mac = mac;
  }

  public String getIp()
  {
    return ip;
  }

  public void setIp(String ip)
  {
    this.ip = ip;
  }

  public int getPort()
  {
    return port;
  }

  public void setPort(int port)
  {
    this.port = port;
  }

  /**
   * 获取16进制的MAC地址
   * 
   * @return
   */
  public byte[] getHexMac()
  {
  	byte[] bytes = new byte[6];
    String[] hex = mac.trim().split("(\\:|\\-)");
    if (hex.length != 6) {
        throw new IllegalArgumentException("Invalid MAC address.");
    }
    try {
        for (int i = 0; i < 6; i++) {
            bytes[i] = (byte) Integer.parseInt(hex[i], 16);
        }
    }catch (NumberFormatException e) {
        throw new IllegalArgumentException("Invalid hex digit in MAC address.");
    }
    return bytes;
  }

}
