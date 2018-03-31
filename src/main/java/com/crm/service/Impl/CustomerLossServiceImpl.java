package com.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.Customer;
import com.crm.entity.CustomerLinkman;
import com.crm.entity.CustomerLoss;
import com.crm.entity.CustomerOrder;
import com.crm.entity.User;
import com.crm.mapper.CustomerLossMapper;
import com.crm.mapper.CustomerMapper;
import com.crm.mapper.CustomerOrderMapper;
import com.crm.service.ICustomerLossService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CustomerLossServiceImpl implements ICustomerLossService{
	
	@Autowired
	private CustomerLossMapper customerLossMapper;
	
	@Autowired
	private CustomerOrderMapper customerOrderMapper;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public DataGrideResult pageList(Integer page, Integer rows, CustomerLoss customerLoss) {
		//1.设置分页
				PageHelper.startPage(page, rows);
				
				List<CustomerLoss> list = 	customerLossMapper.pageList(customerLoss);
				//3.得到满足条件的所有数据的数量，而上面的list是满足这个条件的某一页的数据
				PageInfo pageInfo = new PageInfo<>(list);
				Integer total = (int)pageInfo.getTotal();
				return new DataGrideResult<>(total, list);
	}

	@Override
	public void checkCustomerLoss() {
		System.out.println("CustomerLossServiceImpl.checkCustomerLoss()");
		//1.查看所有流失的客户
		List<Customer> customerList = customerMapper.findCustomberLoss();
		for (Customer customer : customerList) {
			CustomerLoss customerLoss = new CustomerLoss();
			customerLoss.setCustomerNo(customer.getNum());//客户编号
			customerLoss.setCustomerName(customer.getName());//客户名称
			customerLoss.setCustomerManager(customer.getManagerName());//客户经理
			//查找这个客户最后一次的订单信息
			CustomerOrder customerOrder = customerMapper.findLastOrderByCustomerId(customer.getId());
			if (customerOrder != null) {
				customerLoss.setLastOrderTime(customerOrder.getOrderDate());//客户最后一次订单时间
			} else {
				customerLoss.setLastOrderTime(null);
			}
			
			//3.添加到客户流失表里面
			customerLossMapper.insert(customerLoss);
			//4.客户表里面把客户状态修改为1：流失状态
			customer.setStatus(1);
			customerMapper.updateByPrimaryKeySelective(customer);
		}
	
	
	
	}

	@Override
	public ServerResponse selectById(Integer id) {
		CustomerLoss customerLoss = customerLossMapper.selectAll(id);
			if (customerLoss!=null) {
				return ServerResponse.createSuccess("查找成功", customerLoss);
			}
			
		
		return ServerResponse.createError("查找失败");
	}



	
	
	
	
}
