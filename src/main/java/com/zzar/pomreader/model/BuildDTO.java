package com.zzar.pomreader.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="build")
public class BuildDTO {
	
	private PlugInsDTO plugins;

	public PlugInsDTO getPlugins() {
		return plugins;
	}

	@XmlElement(name = "plugins")
	public void setPlugins(PlugInsDTO plugins) {
		this.plugins = plugins;
	}
	
}
