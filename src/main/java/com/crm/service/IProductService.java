package com.crm.service;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.Product;

public interface IProductService {

	DataGrideResult pageList(Integer page, Integer rows, Product product);

	ServerResponse delete(String ids);

	ServerResponse insert(Product product);

	ServerResponse update(Product product);

}
