package com.zzar.pomreader.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="plugins")
public class PlugInsDTO {
	
	private List<PlugInDTO> pluginList;

	@XmlElement(name = "plugin")
	public List<PlugInDTO> getPluginList() {
		return pluginList;
	}

	public void setPluginList(List<PlugInDTO> pluginList) {
		this.pluginList = pluginList;
	}
	
	
}
