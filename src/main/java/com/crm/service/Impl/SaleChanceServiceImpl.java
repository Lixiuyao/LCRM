package com.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.SaleChance;
import com.crm.mapper.SaleChanceMapper;
import com.crm.service.ISaleChanceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


	@Service
	public class SaleChanceServiceImpl implements ISaleChanceService {
		@Autowired
		private SaleChanceMapper saleChanceMapper;
		
		@Override
		public DataGrideResult pageList(Integer page, Integer rows, SaleChance saleChance) {
			//1.设置分页
			PageHelper.startPage(page, rows);
			
			List<SaleChance> list = 	saleChanceMapper.pageList(saleChance);
			//3.得到满足条件的所有数据的数量，而上面的list是满足这个条件的某一页的数据
			PageInfo pageInfo = new PageInfo<>(list);
			Integer total = (int)pageInfo.getTotal();
			return new DataGrideResult<>(total, list);
		}

		@Override
		public ServerResponse delete(String ids) {
			String[] idsArray = ids.split(",");
			int count = saleChanceMapper.deleteAll(idsArray);
			if (count == idsArray.length) {
				return ServerResponse.createSuccess("删除成功");
			}
			return ServerResponse.createError("删除失败");
		}

		@Override
		public ServerResponse insert(SaleChance saleChance) {
			int insert = saleChanceMapper.insert(saleChance);
			if (insert>0) {
				return ServerResponse.createSuccess("添加成功");
			}
			return ServerResponse.createError("添加失败");
		}

		@Override
		public ServerResponse update(SaleChance saleChance) {
			int count = saleChanceMapper.updateByPrimaryKey(saleChance);
			if (count>0) {
				return ServerResponse.createSuccess("修改成功");
			}
			return ServerResponse.createError("修改失败");
		}

		@Override
		public ServerResponse<SaleChance> selectById(Integer id) {
			SaleChance saleChance = saleChanceMapper.selectByPrimaryKey(id);
			if (saleChance != null) {
				return ServerResponse.createSuccess("查找成功", saleChance);
			}
			return ServerResponse.createError("查找失败");
		}

		@Override
		public ServerResponse updateDevResult(Integer id, Integer devResult) {
			Integer count = saleChanceMapper.updateDevResult(id,devResult);
			if (count>0) {
				return ServerResponse.createSuccess("修改成功");
			}
			return ServerResponse.createError("GG思密达");
		}

	}


