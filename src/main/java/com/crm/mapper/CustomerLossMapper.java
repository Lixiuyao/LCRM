package com.crm.mapper;

import com.crm.entity.Customer;
import com.crm.entity.CustomerLoss;
import com.crm.entity.CustomerLossExample;
import com.crm.entity.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerLossMapper {
    int countByExample(CustomerLossExample example);

    int deleteByExample(CustomerLossExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerLoss record);

    int insertSelective(CustomerLoss record);

    List<CustomerLoss> selectByExample(CustomerLossExample example);

    CustomerLoss selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerLoss record, @Param("example") CustomerLossExample example);

    int updateByExample(@Param("record") CustomerLoss record, @Param("example") CustomerLossExample example);

    int updateByPrimaryKeySelective(CustomerLoss record);

    int updateByPrimaryKey(CustomerLoss record);

	List<CustomerLoss> pageList(CustomerLoss customerLoss);

	

	CustomerLoss selectAll(Integer id);
}