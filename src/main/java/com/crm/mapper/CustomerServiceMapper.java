package com.crm.mapper;

import com.crm.entity.CustomerService;
import com.crm.entity.CustomerServiceExample;
import com.crm.vo.CstmrVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerServiceMapper {
    int countByExample(CustomerServiceExample example);

    int deleteByExample(CustomerServiceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerService record);

    int insertSelective(CustomerService record);

    List<CustomerService> selectByExample(CustomerServiceExample example);

    CustomerService selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerService record, @Param("example") CustomerServiceExample example);

    int updateByExample(@Param("record") CustomerService record, @Param("example") CustomerServiceExample example);

    int updateByPrimaryKeySelective(CustomerService record);

    int updateByPrimaryKey(CustomerService record);

	List<CstmrVo> eChartsTu();
}