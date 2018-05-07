package com.crm.service;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.Permission;

public interface IPermissionService {

	/**
	 * 返回datagride分页和搜索之后的数据
	 * @param page 第几页
	 * @param rows 每一个多少个
	 * @param permission 封装搜索条件
	 * @return
	 */
	DataGrideResult pageList(Integer page, Integer rows, Permission permission);

	ServerResponse delete(String ids);

	ServerResponse add(Permission permission);

	ServerResponse update(Permission permission);

	DataGrideResult selectByRoleId(Integer roleId);
}
