package com.crm.mapper;

import com.crm.entity.User;
import com.crm.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	List<User> pageList(User user);

	int deleteAll(String[] idsArray);

	List<User> findUserName();

	User findUserByName(@Param("name")String name,@Param("password")String password);
	
	List<Long> selectRoleIdByUserId(Long userId);
	
	
}