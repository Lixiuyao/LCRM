package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.DataDic;
import com.crm.service.IDataDicService;

@Controller
@RequestMapping("/datadic")
public class DatadicController {
	@Autowired
	private IDataDicService datadicService;
	
	
	@RequestMapping("/index")
	public String index(){
		
		return "datadic_index";
	}
	
	
	@RequestMapping("/pageList")
	@ResponseBody
	public DataGrideResult pageList(Integer page,Integer rows,DataDic datadic){
		
		return datadicService.pageList(page,rows,datadic);
		
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public ServerResponse delete(String ids){
		return datadicService.delete(ids);
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public ServerResponse insert(DataDic datadic){
		return datadicService.insert(datadic);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(DataDic datadic){
		return datadicService.update(datadic);
	}
	
	@RequestMapping("/findDatadicName")
	@ResponseBody
	public List<DataDic> findDatadicName(){
		List<DataDic> findDatadicName = datadicService.findDatadicName();
		for (DataDic dataDic : findDatadicName) {
			System.out.println(dataDic);
		}
		return findDatadicName ;
	}
	
	
}
