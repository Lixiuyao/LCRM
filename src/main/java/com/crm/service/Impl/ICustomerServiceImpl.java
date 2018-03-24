package com.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.common.DataGrideResult;
import com.crm.entity.Customer;
import com.crm.mapper.CustomerMapper;
import com.crm.service.ICustomerService;
@Service
public class ICustomerServiceImpl implements ICustomerService{
	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public DataGrideResult<Customer> pageList() {
		int total = customerMapper.pageList().size();
		List<Customer>  rows =customerMapper.pageList();
//		for (Customer customer : rows) {
//			System.out.println(customer);
//		}
		DataGrideResult<Customer> list =new DataGrideResult<>(total, rows);
		return list;
	}

}
