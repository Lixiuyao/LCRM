package com.crm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.SaleChance;

public interface ISaleChanceService {

	DataGrideResult pageList(Integer page, Integer rows, SaleChance saleChance);

	ServerResponse delete(String ids);

	ServerResponse insert(SaleChance saleChance);

	ServerResponse update(SaleChance saleChance);

	ServerResponse<SaleChance> selectById(Integer id);

	ServerResponse<SaleChance> updateDevResult(Integer id, Integer devResult);

	void exportExcel(HttpServletResponse response);
}
