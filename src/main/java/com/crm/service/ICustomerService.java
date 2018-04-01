package com.crm.service;



import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.Customer;
import com.crm.entity.SaleChance;
import com.crm.vo.CstmrVo;
import com.crm.vo.CustomerVo;


public interface ICustomerService {

	DataGrideResult<Customer> pageList();

	DataGrideResult<CustomerVo> pageListGX();

	ServerResponse<Customer> selectById(Integer id);

	ServerResponse<CstmrVo> getCountUser();

	ServerResponse<CstmrVo> eChartsTu();
	
}
