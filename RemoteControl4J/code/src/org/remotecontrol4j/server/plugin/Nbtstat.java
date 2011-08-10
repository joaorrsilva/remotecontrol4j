package org.remotecontrol4j.server.plugin;

import org.remotecontrol4j.server.runtime.Container;
import org.remotecontrol4j.server.runtime.Executor;

public class Nbtstat implements Container
{

	public String load() {
		return Executor.win_nbtstat.getPrototype();
	}

}
