package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.CusDevPlan;
import com.crm.entity.CustomerLossMeasure;
import com.crm.service.ICustomerLossMeasure;

@Controller
@RequestMapping("/customerLossMeasure")
public class CustomerLossMeasureController {
	@Autowired
	private ICustomerLossMeasure customerLossMeasu;
	
	
	
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<CustomerLossMeasure> selectAll(Integer lossId) {
		return customerLossMeasu.selectAll(lossId);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public ServerResponse delete(Integer lossId) {
		return customerLossMeasu.delete(lossId);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(CustomerLossMeasure customerLossMeasure) {
		return customerLossMeasu.add(customerLossMeasure);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(CustomerLossMeasure customerLossMeasure) {
		return customerLossMeasu.update(customerLossMeasure);
	}
}
