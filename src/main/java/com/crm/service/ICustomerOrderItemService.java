package com.crm.service;

import java.util.List;

import com.crm.common.ServerResponse;
import com.crm.entity.CustomerOrder;
import com.crm.entity.OrderItem;

public interface ICustomerOrderItemService {

	List<OrderItem> selectById(Integer orderId);

	ServerResponse delete(Integer orderId);

	ServerResponse add(OrderItem OrderItem);

	ServerResponse update(OrderItem OrderItem);

}
