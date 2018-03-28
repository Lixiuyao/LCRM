package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.CusDevPlan;
import com.crm.service.ICusDevPlanService;

@Controller
@RequestMapping("/cusDevPlan")
public class CusDevPlanController {
	
	@Autowired
	private ICusDevPlanService cusDevPlanService;
	
	
	@RequestMapping("/index")
	public String index(){
		return "cus_Dev_plan_index";
	}
	
	@RequestMapping("/selectAll")
	@ResponseBody
	public DataGrideResult selectAll(Integer saleChanceId) {
		return cusDevPlanService.selectAll(saleChanceId);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public ServerResponse delete(Integer id) {
		return cusDevPlanService.delete(id);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(CusDevPlan cusDevPlan) {
		return cusDevPlanService.add(cusDevPlan);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(CusDevPlan cusDevPlan) {
		return cusDevPlanService.update(cusDevPlan);
	}
	
}
