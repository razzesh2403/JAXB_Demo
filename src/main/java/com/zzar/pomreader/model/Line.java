package com.zzar.pomreader.model;

public class Line {
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Line [text=" + text + "]";
	}
	
}
