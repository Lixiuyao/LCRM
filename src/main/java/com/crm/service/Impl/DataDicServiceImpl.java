package com.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.DataDic;
import com.crm.mapper.DataDicMapper;
import com.crm.service.IDataDicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class DataDicServiceImpl implements IDataDicService {
	@Autowired
	private DataDicMapper datadicMapper;
	
	@Override
	public DataGrideResult pageList(Integer page, Integer rows, DataDic datadic) {
		//1.设置分页
		PageHelper.startPage(page, rows);
		
		List<DataDic> list = 	datadicMapper.pageList(datadic);
		//3.得到满足条件的所有数据的数量，而上面的list是满足这个条件的某一页的数据
		PageInfo pageInfo = new PageInfo<>(list);
		Integer total = (int)pageInfo.getTotal();
		return new DataGrideResult<>(total, list);
	}

	@Override
	public ServerResponse delete(String ids) {
		String[] idsArray = ids.split(",");
		int count = datadicMapper.deleteAll(idsArray);
		if (count == idsArray.length) {
			return ServerResponse.createSuccess("删除成功");
		}
		return ServerResponse.createError("删除失败");
	}

	@Override
	public ServerResponse insert(DataDic datadic) {
		int insert = datadicMapper.insert(datadic);
		if (insert>0) {
			return ServerResponse.createSuccess("添加成功");
		}
		return ServerResponse.createError("添加失败");
	}

	@Override
	public ServerResponse update(DataDic datadic) {
		int count = datadicMapper.updateByPrimaryKey(datadic);
		if (count>0) {
			return ServerResponse.createSuccess("修改成功");
		}
		return ServerResponse.createError("修改失败");
	}

	@Override
	public List<DataDic> findDatadicName() {
		
		
		return datadicMapper.findDatadicName();
	}

	

}
