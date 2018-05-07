package com.crm.mapper;

import java.util.List;

import com.crm.entity.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> pageList(Role role);

	int deleteAll(String[] idsArray);
}