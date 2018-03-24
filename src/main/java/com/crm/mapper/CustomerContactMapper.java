package com.crm.mapper;

import com.crm.entity.CustomerContact;
import com.crm.entity.CustomerContactExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerContactMapper {
    int countByExample(CustomerContactExample example);

    int deleteByExample(CustomerContactExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerContact record);

    int insertSelective(CustomerContact record);

    List<CustomerContact> selectByExample(CustomerContactExample example);

    CustomerContact selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerContact record, @Param("example") CustomerContactExample example);

    int updateByExample(@Param("record") CustomerContact record, @Param("example") CustomerContactExample example);

    int updateByPrimaryKeySelective(CustomerContact record);

    int updateByPrimaryKey(CustomerContact record);
}