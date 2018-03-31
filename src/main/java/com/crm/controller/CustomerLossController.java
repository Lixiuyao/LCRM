package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.Customer;
import com.crm.entity.CustomerLoss;
import com.crm.service.ICustomerLossService;

@Controller
@RequestMapping("/customerLoss")
public class CustomerLossController {
	@Autowired
	private ICustomerLossService customerLossService;
	
	
	@RequestMapping("index")
	public String index(){
		return "customber_loss_index";
	}
	
	
	@RequestMapping("/pageList")
	@ResponseBody
	public DataGrideResult pageList(Integer page,Integer rows,CustomerLoss customerLoss){
		
		return customerLossService.pageList(page,rows,customerLoss);
		
	}
	
	
	@RequestMapping("JHindex")
	public String JHindex(){
		return "customber_loss_manager_index";
	}
	
	
	
	@RequestMapping("/selectById")
	@ResponseBody
	public ServerResponse<CustomerLoss> selectById(Integer id) {
		
		return customerLossService.selectById(id);
	}
	
	
}
