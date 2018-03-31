package com.crm.service;

import java.util.List;

import com.crm.common.ServerResponse;
import com.crm.entity.CustomerOrder;

public interface ICustomerOrderService {

	List<CustomerOrder> selectById(Integer id);
	
}
