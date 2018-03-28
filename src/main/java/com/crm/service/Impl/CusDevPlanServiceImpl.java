package com.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.CusDevPlan;
import com.crm.mapper.CusDevPlanMapper;
import com.crm.service.ICusDevPlanService;
@Service
public class CusDevPlanServiceImpl implements ICusDevPlanService{
	@Autowired
	private CusDevPlanMapper cusDevPlanMapper;
		
	
	@Override
	public DataGrideResult selectAll(Integer saleChanceId) {
		List<CusDevPlan> list = cusDevPlanMapper.selectAll(saleChanceId);
		return new DataGrideResult<>(list.size(), list);
	}
	
	@Override
	public ServerResponse delete(Integer id) {
		int count = cusDevPlanMapper.deleteByPrimaryKey(id);
		if (count > 0) {
			return ServerResponse.createSuccess("删除成功");
		}
		return ServerResponse.createError("删除失败");
	}

	@Override
	public ServerResponse add(CusDevPlan cusDevPlan) {
		int count = cusDevPlanMapper.insert(cusDevPlan);
		if (count > 0) {
			return ServerResponse.createSuccess("添加成功");
		}
		return ServerResponse.createError("添加失败");
	}
	
	@Override
	public ServerResponse update(CusDevPlan cusDevPlan) {
		int count = cusDevPlanMapper.updateByPrimaryKey(cusDevPlan);
		if (count > 0) {
			return ServerResponse.createSuccess("更新成功");
		}
		return ServerResponse.createError("更新失败");
	}
}


