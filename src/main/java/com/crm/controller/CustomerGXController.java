package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.User;
import com.crm.service.ICustomerService;
import com.crm.vo.CstmrVo;
import com.crm.vo.CustomerVo;

@Controller
@RequestMapping("/customerGx")
public class CustomerGXController {
	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping("/index")
	public String index(){
		return "customer_GX";
	}
	
	
	@RequestMapping("/pageAll")
	@ResponseBody
	public DataGrideResult<CustomerVo> pageListGX(){
		return  customerService.pageListGX();
	}
	
	@RequestMapping("/tubiaoindex")
	public String tubiaoindex(){
		return "tubiao";
	}
	
	@RequestMapping("/getCountUser")
	@ResponseBody
	public ServerResponse<CstmrVo> getCountUser(){
		return  customerService.getCountUser();
	}
	@RequestMapping("/customerService")
	public String customerService(){
		return "customer_service";
	}
	
	@RequestMapping("/ECharts")
	@ResponseBody
	public ServerResponse<CstmrVo> ECharts(){
		return  customerService.eChartsTu();
	}
	
}
