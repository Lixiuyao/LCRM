package com.crm.service;

import java.util.List;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.CustomerLinkman;

public interface ICustomerLinkMan {

	List<CustomerLinkman> selectAll(Integer id);

	ServerResponse delete(Integer id);

	ServerResponse add(CustomerLinkman customerLinkman);

	ServerResponse update(CustomerLinkman customerLinkman);

}
