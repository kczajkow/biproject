package com.czajkowski.operation.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czajkowski.operation.service.OperationService;

@Controller
public class OperationController {

	@Autowired
	private OperationService operationService;
	
	@RequestMapping("/dashboard")
	public String showDashboard(Map<String, Object> map) {
		
		map.put("operationList", operationService.listOperation());
		
		return "dashboard";
	}

}
