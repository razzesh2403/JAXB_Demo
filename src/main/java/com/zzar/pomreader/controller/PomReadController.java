package com.zzar.pomreader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zzar.pomreader.model.PlugInsDTO;
import com.zzar.pomreader.model.PomOne;
import com.zzar.pomreader.model.PomResponse;
import com.zzar.pomreader.service.PomReadService;

@RestController
public class PomReadController {
	
	@Autowired
	private PomReadService pomReadService;

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello...!";
	}
	
	@GetMapping("/pomReport")
	public PlugInsDTO getPomReport() {
		return pomReadService.getPomReport();
	}
	
	@GetMapping("/pomReportNew")
	public List<PomResponse> getPomReportNew() {
		return pomReadService.getPomOne();
	}
}
