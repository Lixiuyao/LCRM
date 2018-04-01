package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.common.ServerResponse;
import com.crm.entity.CustomerLossMeasure;
import com.crm.entity.CustomerOrder;
import com.crm.entity.OrderItem;
import com.crm.service.ICustomerOrderItemService;
import com.crm.service.ICustomerOrderService;

@Controller
@RequestMapping("/customerOrderItem")
public class CustomerOrderItemController {
	
	@Autowired
	private ICustomerOrderItemService customerOrderItemService;
	
	
	
	@RequestMapping("/index")
	public String index(){
		return "order_item";
	}
	
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<OrderItem> selectAll(Integer orderId) {
		return customerOrderItemService.selectById(orderId);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public ServerResponse delete(Integer orderId) {
		return customerOrderItemService.delete(orderId);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(OrderItem OrderItem) {
		return customerOrderItemService.add(OrderItem);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(OrderItem OrderItem) {
		return customerOrderItemService.update(OrderItem);
	}
	
	
	
}
