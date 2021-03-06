package com.crm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.SaleChance;
import com.crm.service.ISaleChanceService;

@Controller
@RequestMapping("/saleChance")
public class SaleChanceController {
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	
	@Autowired
	private ISaleChanceService saleChanceService;
	
	
	@RequestMapping("/index")
	public String index(){
		return "saleChance_index";
	}
	
	
	
	@RequestMapping("/pageList")
	@ResponseBody
	public DataGrideResult pageList(Integer page,Integer rows,SaleChance saleChance){
		
		return saleChanceService.pageList(page,rows,saleChance);
		
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public ServerResponse delete(String ids){
		return saleChanceService.delete(ids);
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public ServerResponse insert(SaleChance saleChance){
		return saleChanceService.insert(saleChance);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(SaleChance saleChance){
		return saleChanceService.update(saleChance);
	}
	
	@RequestMapping("/cusDevPlan")
	public String cusDevPlan(){
		return "cus_Dev_Plan";
	}
	
	@RequestMapping("/selectById")
	@ResponseBody
	public ServerResponse<SaleChance> selectById(Integer id) {
		return saleChanceService.selectById(id);
	}
	
	@RequestMapping("/updateDevResult")
	@ResponseBody
	public ServerResponse updateDevResult(Integer saleChanceId,Integer devResult) {
		System.out.println(devResult);
		System.err.println(saleChanceId);
		return saleChanceService.updateDevResult(saleChanceId,devResult);
	}
	
	@RequestMapping("/exportExcel")
	public void exportExcel(HttpServletResponse response){
		saleChanceService.exportExcel(response);
	}
	
}
