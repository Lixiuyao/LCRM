package com.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.CustomerLinkman;
import com.crm.mapper.CustomerLinkmanMapper;
import com.crm.service.ICustomerLinkMan;

@Service
public class CustomerLinkmanImpl implements ICustomerLinkMan {

	@Autowired
	private CustomerLinkmanMapper customerLinkmanMapper;

	

	@Override
	public ServerResponse delete(Integer id) {
		int count =customerLinkmanMapper.deleteByPrimaryKey(id);
		if(count>0){
			return ServerResponse.createSuccess("成功");
		}
		return null;
	}

	@Override
	public ServerResponse add(CustomerLinkman customerLinkman) {
		int count =customerLinkmanMapper.insert(customerLinkman);
		if(count>0){
			return ServerResponse.createSuccess("成功");
		}
		return null;
	}

	@Override
	public ServerResponse update(CustomerLinkman customerLinkman) {
		int count = customerLinkmanMapper.updateByPrimaryKeySelective(customerLinkman);
		if(count>0){
			return ServerResponse.createSuccess("成功");
		}
		return null;
	}

	@Override
	public List<CustomerLinkman> selectAll(Integer id) {
		List<CustomerLinkman> list = customerLinkmanMapper.selectAll(id);
		return list;
	}
	
	
	
	
	
}
