package com.zzar.pomreader.model;

import java.util.List;

public class PomTwo {
	List<Line> lines;

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

	@Override
	public String toString() {
		return "PomTwo [lines=" + lines + "]";
	}
	
}
