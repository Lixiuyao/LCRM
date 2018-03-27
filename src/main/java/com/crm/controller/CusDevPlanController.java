package com.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cusDevPlan")
public class CusDevPlanController {
	
	@RequestMapping("/index")
	public String index(){
		return "cus_Dev_plan_index";
	}
}
