package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.common.ServerResponse;
import com.crm.entity.CustomerOrder;
import com.crm.service.ICustomerOrderService;

@Controller
@RequestMapping("/customerOrder")
public class CustomerOrderController {
	@Autowired
	private ICustomerOrderService customerOrderService;
	
	
	@RequestMapping("/index")
	public String index(){
		return "customer_order_index";
	}
	
	@RequestMapping("/selectById")
	@ResponseBody
	public List<CustomerOrder> selectById(Integer customerId){
		return customerOrderService.selectById(customerId);
	}
	
}
