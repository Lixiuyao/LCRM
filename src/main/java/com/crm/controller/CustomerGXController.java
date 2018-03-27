package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.common.DataGrideResult;
import com.crm.service.ICustomerService;
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
	
	
	
}
