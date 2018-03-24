package com.crm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.common.DataGrideResult;
import com.crm.entity.Customer;
import com.crm.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	
	
	@RequestMapping("/show")
	public String show(){
	  return	"customer_index";
	}
	
	@RequestMapping("/pageList")
	@ResponseBody
	public DataGrideResult<Customer> pageList(){
		
	  return	customerService.pageList();
	}
	
}
