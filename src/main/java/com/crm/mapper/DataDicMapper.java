package com.crm.mapper;

import com.crm.entity.DataDic;
import com.crm.entity.DataDicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataDicMapper {
    int countByExample(DataDicExample example);

    int deleteByExample(DataDicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DataDic record);

    int insertSelective(DataDic record);

    List<DataDic> selectByExample(DataDicExample example);

    DataDic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DataDic record, @Param("example") DataDicExample example);

    int updateByExample(@Param("record") DataDic record, @Param("example") DataDicExample example);

    int updateByPrimaryKeySelective(DataDic record);

    int updateByPrimaryKey(DataDic record);

	List<DataDic> pageList(DataDic datadic);

	int deleteAll(String[] idsArray);

	List<DataDic> findDatadicName();
}