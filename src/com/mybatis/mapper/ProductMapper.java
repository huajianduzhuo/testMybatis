package com.mybatis.mapper;

import java.util.List;

import pojo.Product;

public interface ProductMapper {
	
	public Product getProductById(int id) throws Exception;
	public List<Product> getProductByName(String name) throws Exception;
	public void addProduct(Product product) throws Exception;
	public void deleteProduct(Integer id) throws Exception;
	public void modifyProduct(Product product) throws Exception;

}
