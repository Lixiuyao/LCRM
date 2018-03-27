package com.crm.mapper;

import com.crm.entity.SaleChance;
import com.crm.entity.SaleChanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleChanceMapper {
    int countByExample(SaleChanceExample example);

    int deleteByExample(SaleChanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SaleChance record);

    int insertSelective(SaleChance record);

    List<SaleChance> selectByExample(SaleChanceExample example);

    SaleChance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SaleChance record, @Param("example") SaleChanceExample example);

    int updateByExample(@Param("record") SaleChance record, @Param("example") SaleChanceExample example);

    int updateByPrimaryKeySelective(SaleChance record);

    int updateByPrimaryKey(SaleChance record);

	int deleteAll(String[] idsArray);

	List<SaleChance> pageList(SaleChance saleChance);

	Integer updateDevResult(Integer id, Integer devResult);
}