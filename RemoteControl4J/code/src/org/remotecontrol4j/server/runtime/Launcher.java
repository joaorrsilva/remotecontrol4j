package org.remotecontrol4j.server.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 根据手工配置运行相应的命令
 * 
 * @author and4walker
 *
 */
public class Launcher
{

	/**
	 * 执行系统原生命令
	 * @param cmd
	 * @throws Exception
	 */
	public static String  run(final String cmd) throws Exception{
		String msg = null;
		Process process = null;
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferReader = null;
		try {
			process = Runtime.getRuntime().exec(cmd);
		  inputStream = process.getInputStream();
		  inputStreamReader = new InputStreamReader(inputStream);
		  bufferReader = new BufferedReader(inputStreamReader);
      while ((msg=bufferReader.readLine()) != null) {
      	msg += msg;
      }
		} catch (IOException e) {
			e.printStackTrace();
			process.destroy();
		} finally{
			if(null != bufferReader){
				bufferReader.close();
				bufferReader = null;
			}
			if(null != inputStreamReader){
				inputStreamReader.close();
				inputStreamReader = null;
			}
			if(null != inputStream){
				inputStream.close();
				inputStream = null;
			}
			if(null != process){
				process.destroy();
			}
		}
		return msg;
	}
	
}
