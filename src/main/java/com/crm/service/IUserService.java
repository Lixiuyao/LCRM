package com.crm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.User;

public interface IUserService {

	DataGrideResult pageList(Integer page, Integer rows, User user);

	ServerResponse delete(String ids);

	ServerResponse insert(User user);

	ServerResponse update(User user);

	List<User> findCustomerName();

	ServerResponse selectByName(String name, String password, HttpServletRequest request);

}
