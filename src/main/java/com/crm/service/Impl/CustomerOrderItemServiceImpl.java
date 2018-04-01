package com.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.common.ServerResponse;
import com.crm.entity.CustomerOrder;
import com.crm.entity.OrderItem;
import com.crm.mapper.OrderItemMapper;
import com.crm.service.ICustomerOrderItemService;
@Service
public class CustomerOrderItemServiceImpl implements ICustomerOrderItemService{
	
	@Autowired
	private OrderItemMapper orderItemMapper;
	
	
	@Override
	public List<OrderItem> selectById(Integer orderId) {
		List<OrderItem> orderItems = orderItemMapper.selectById(orderId);
		return orderItems;
	}

	@Override
	public ServerResponse delete(Integer orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerResponse add(OrderItem OrderItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerResponse update(OrderItem OrderItem) {
		// TODO Auto-generated method stub
		return null;
	}



	
}
