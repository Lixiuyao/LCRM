package com.crm.mapper;

import java.util.List;

import com.crm.entity.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    List<Permission> pageList(Permission Permission);

	int deleteAll(String[] idsArray);

	List<Permission> selectByRoleId(Integer roleId);

	List<Permission> selectByUserId(Long userId);

	Permission selectByResource(String resource);
}