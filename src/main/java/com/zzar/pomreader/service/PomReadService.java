package com.zzar.pomreader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzar.pomreader.model.PlugInsDTO;
import com.zzar.pomreader.model.PomOne;
import com.zzar.pomreader.model.PomResponse;
import com.zzar.pomreader.restClient.PomRestInvoker;
import com.zzar.pomreader.util.PomReadUtil;

@Service
public class PomReadService {
	
	@Autowired
	private PomReadUtil pomReadUtil;
	
	@Autowired
	private PomRestInvoker pomRestInvoker;
	
	public PlugInsDTO getPomReport() {
		return pomReadUtil.getPomReport();
	}
	
	public List<PomResponse> getPomOne() {
		return pomRestInvoker.getPomOne();
	}
}
