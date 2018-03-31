package com.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.CustomerLinkman;
import com.crm.entity.CustomerLossMeasure;
import com.crm.mapper.CustomerLossMeasureMapper;
import com.crm.service.ICustomerLossMeasure;

@Service
public class CustomerLossMeasureImpl implements ICustomerLossMeasure{
	@Autowired
	private CustomerLossMeasureMapper customerLossMeasureMapper;
	
	
	


	@Override
	public ServerResponse delete(Integer id) {
		int count =customerLossMeasureMapper.deleteByPrimaryKey(id);
		if(count>0){
			return ServerResponse.createSuccess("成功");
		}
		return null;
	}

	@Override
	public ServerResponse add(CustomerLossMeasure customerLossMeasure) {
		int count =customerLossMeasureMapper.insert(customerLossMeasure);
		if(count>0){
			return ServerResponse.createSuccess("成功");
		}
		return null;
	}

	@Override
	public ServerResponse update(CustomerLossMeasure customerLossMeasure) {
		int count = customerLossMeasureMapper.updateByPrimaryKeySelective(customerLossMeasure);
		if(count>0){
			return ServerResponse.createSuccess("成功");
		}
		return null;
	}

	@Override
	public List<CustomerLossMeasure> selectAll(Integer id) {
		List<CustomerLossMeasure> list = customerLossMeasureMapper.selectAll(id);
		return list;
	}
	
	

}
