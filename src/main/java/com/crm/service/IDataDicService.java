package com.crm.service;

import java.util.List;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.DataDic;

public interface IDataDicService {

	DataGrideResult pageList(Integer page, Integer rows, DataDic datadic);

	ServerResponse delete(String ids);

	ServerResponse insert(DataDic datadic);

	ServerResponse update(DataDic datadic);

	List<DataDic> findDatadicName();

}
