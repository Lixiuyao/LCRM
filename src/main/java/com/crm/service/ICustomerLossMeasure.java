package com.crm.service;

import java.util.List;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.CustomerLossMeasure;

public interface ICustomerLossMeasure {

	List<CustomerLossMeasure> selectAll(Integer lossId);

	ServerResponse delete(Integer lossId);

	ServerResponse add(CustomerLossMeasure customerLossMeasure);

	ServerResponse update(CustomerLossMeasure customerLossMeasure);

}
