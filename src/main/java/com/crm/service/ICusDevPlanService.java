package com.crm.service;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.CusDevPlan;

public interface ICusDevPlanService {

	DataGrideResult selectAll(Integer saleChanceId);

	ServerResponse delete(Integer id);

	ServerResponse add(CusDevPlan cusDevPlan);

	ServerResponse update(CusDevPlan cusDevPlan);

}
