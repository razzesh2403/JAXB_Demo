package com.zzar.pomreader.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="project")
public class ProjectDTO {
	private BuildDTO build;

	public BuildDTO getBuild() {
		return build;
	}

	public void setBuild(BuildDTO build) {
		this.build = build;
	}
	
}
