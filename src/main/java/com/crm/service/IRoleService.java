package com.crm.service;

import java.util.List;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.Role;

public interface IRoleService {

	/**
	 * 返回datagride分页和搜索之后的数据
	 * @param page 第几页
	 * @param rows 每一个多少个
	 * @param role 封装搜索条件
	 * @return
	 */
	DataGrideResult pageList(Integer page, Integer rows, Role role);

	ServerResponse delete(String ids);

	ServerResponse add(Role role);

	ServerResponse update(Role role);

	List<Role> selectAll();
}
