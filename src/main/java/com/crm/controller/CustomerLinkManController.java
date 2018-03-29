package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.common.ServerResponse;
import com.crm.entity.CustomerLinkman;
import com.crm.service.ICustomerLinkMan;

@Controller
@RequestMapping("/customerLinkMan")
public class CustomerLinkManController {
	@Autowired
	private ICustomerLinkMan customerLinkMan;
	
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<CustomerLinkman> selectAll(Integer Id) {
		return customerLinkMan.selectAll(Id);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public ServerResponse delete(Integer id) {
		return customerLinkMan.delete(id);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(CustomerLinkman customerLinkman) {
		return customerLinkMan.add(customerLinkman);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(CustomerLinkman customerLinkman) {
		return customerLinkMan.update(customerLinkman);
	}
	
}
