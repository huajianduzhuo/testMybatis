package com.mybatis.dao;

import pojo.Product;

public interface ProductDao {
	
	public Product getProductById(Integer id) throws Exception;

}
