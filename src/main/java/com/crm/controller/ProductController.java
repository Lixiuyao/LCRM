package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.Product;
import com.crm.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProductService productService;
	
	
	@RequestMapping("/index")
	public String index(){
		
		return "product_index";
	}
	
	
	@RequestMapping("/pageList")
	@ResponseBody
	public DataGrideResult pageList(Integer page,Integer rows,Product product){
		
		return productService.pageList(page,rows,product);
		
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public ServerResponse delete(String ids){
		return productService.delete(ids);
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public ServerResponse insert(Product product){
		return productService.insert(product);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(Product product){
		return productService.update(product);
	}
}
