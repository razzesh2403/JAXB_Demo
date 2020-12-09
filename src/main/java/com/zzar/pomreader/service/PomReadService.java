package com.zzar.pomreader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzar.pomreader.model.PlugInsDTO;
import com.zzar.pomreader.util.PomReadUtil;

@Service
public class PomReadService {
	
	@Autowired
	private PomReadUtil pomReadUtil;
	
	public PlugInsDTO getPomReport() {
		return pomReadUtil.getPomReport();
	}
}
