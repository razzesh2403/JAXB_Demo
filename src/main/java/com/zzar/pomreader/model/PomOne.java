package com.zzar.pomreader.model;

import java.util.List;

public class PomOne {
	private String size;
	private String limit;
	private String isLastPage;
	private List<Value> values;
	private String start;
	private String nextPageStart;
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public String getIsLastPage() {
		return isLastPage;
	}
	public void setIsLastPage(String isLastPage) {
		this.isLastPage = isLastPage;
	}
	public List<Value> getValues() {
		return values;
	}
	public void setValues(List<Value> values) {
		this.values = values;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getNextPageStart() {
		return nextPageStart;
	}
	public void setNextPageStart(String nextPageStart) {
		this.nextPageStart = nextPageStart;
	}
	
}
