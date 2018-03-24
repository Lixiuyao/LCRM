package com.crm.service;



import com.crm.common.DataGrideResult;
import com.crm.entity.Customer;


public interface ICustomerService {

	DataGrideResult<Customer> pageList();
	
}
