package com.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.Product;
import com.crm.mapper.ProductMapper;
import com.crm.service.IProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public DataGrideResult pageList(Integer page, Integer rows, Product product) {
		//1.设置分页
		PageHelper.startPage(page, rows);
		
		List<Product> list = 	productMapper.pageList(product);
		//3.得到满足条件的所有数据的数量，而上面的list是满足这个条件的某一页的数据
		PageInfo pageInfo = new PageInfo<>(list);
		Integer total = (int)pageInfo.getTotal();
		return new DataGrideResult<>(total, list);
	}

	@Override
	public ServerResponse delete(String ids) {
		String[] idsArray = ids.split(",");
		int count = productMapper.deleteAll(idsArray);
		if (count == idsArray.length) {
			return ServerResponse.createSuccess("删除成功");
		}
		return ServerResponse.createError("删除失败");
	}

	@Override
	public ServerResponse insert(Product product) {
		int insert = productMapper.insert(product);
		if (insert>0) {
			return ServerResponse.createSuccess("添加成功");
		}
		return ServerResponse.createError("添加失败");
	}

	@Override
	public ServerResponse update(Product product) {
		int count = productMapper.updateByPrimaryKey(product);
		if (count>0) {
			return ServerResponse.createSuccess("修改成功");
		}
		return ServerResponse.createError("修改失败");
	}

}
