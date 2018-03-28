package com.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.Customer;
import com.crm.entity.SaleChance;
import com.crm.mapper.CustomerMapper;
import com.crm.service.ICustomerService;
import com.crm.vo.CustomerVo;
@Service
public class ICustomerServiceImpl implements ICustomerService{
	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public DataGrideResult<Customer> pageList() {
		int total = customerMapper.pageList().size();
		List<Customer>  rows =customerMapper.pageList();

		DataGrideResult<Customer> list =new DataGrideResult<>(total, rows);
		return list;
	}

	@Override
	public DataGrideResult<CustomerVo> pageListGX() {
		int total = customerMapper.pageListGX().size();
		List<CustomerVo>  rows =customerMapper.pageListGX();
		DataGrideResult<CustomerVo> list =new DataGrideResult<>(total, rows);
		return list;
	}

	@Override
	public ServerResponse<Customer> selectById(Integer id) {
		Customer customer = customerMapper.selectByPrimaryKey(id);
		if (customer!=null) {
			return ServerResponse.createSuccess("查找成功", customer);
		}
		return ServerResponse.createError("失败");
	}

}
