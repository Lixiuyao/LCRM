package com.crm.mapper;

import com.crm.entity.RolePermission;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);

	int deleteByRoleId(Long roleId);
}