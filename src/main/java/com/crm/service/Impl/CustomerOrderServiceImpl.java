package com.crm.service.Impl;

import java.util.List;

import org.apache.commons.codec.net.QCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.common.ServerResponse;
import com.crm.entity.CustomerOrder;
import com.crm.mapper.CustomerOrderMapper;
import com.crm.service.ICustomerOrderService;
@Service
public class CustomerOrderServiceImpl implements ICustomerOrderService{
	@Autowired
	private CustomerOrderMapper customerOrderMapper; 
	
	
	@Override
	public List<CustomerOrder> selectById(Integer id) {
		List<CustomerOrder> list =  customerOrderMapper.selectById(id);
		if (list.size()>0) {
			return list;
		}
		return null;
	}

}
