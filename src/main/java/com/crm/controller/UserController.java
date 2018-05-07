package com.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.User;
import com.crm.entity.User;
import com.crm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	
	@RequestMapping("/index")
	public String index(){
		
		return "user_index";
	}
	@RequestMapping("/index2")
	public String index2(){
		
		return "user_index2";
	}
	
	@RequestMapping("/pageList")
	@ResponseBody
	public DataGrideResult pageList(Integer page,Integer rows,User user){
		
		return userService.pageList(page,rows,user);
		
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public ServerResponse delete(String ids){
		return userService.delete(ids);
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public ServerResponse insert(User user){
		return userService.insert(user);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(User user){
		return userService.update(user);
	}
	
	
	@RequestMapping("/selectCustomerManagerList")
	@ResponseBody
	public List<User>  selectCustomerManagerList(){
		List<User> findName = userService.findCustomerName();
		for (User user : findName) {
			System.out.println(user);
		}
		return findName ;
	}
	
	@RequestMapping("login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("logon")
	@ResponseBody
	public ServerResponse logon(String name ,String password,HttpServletRequest request){
		System.err.println(name);
		System.err.println(password);
		return userService.selectByName(name,password,request);
	}
	
	
	
	@RequestMapping("getLoginPage")
	public String getLoginPage(){
		return "login";
	}
	
}
