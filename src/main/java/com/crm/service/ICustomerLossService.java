package com.crm.service;

import java.util.List;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.CustomerLoss;

public interface ICustomerLossService {

	DataGrideResult pageList(Integer page, Integer rows, CustomerLoss customerLoss);

	void checkCustomerLoss();

	ServerResponse<CustomerLoss> selectById(Integer id);
	
}
