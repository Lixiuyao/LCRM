package com.crm.service;



import com.crm.common.DataGrideResult;
import com.crm.entity.Customer;
import com.crm.vo.CustomerVo;


public interface ICustomerService {

	DataGrideResult<Customer> pageList();

	DataGrideResult<CustomerVo> pageListGX();
	
}
