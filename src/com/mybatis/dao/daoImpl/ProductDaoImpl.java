package com.mybatis.dao.daoImpl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pojo.Product;

import com.mybatis.dao.ProductDao;

public class ProductDaoImpl implements ProductDao {
	//为实现类注入sqlSessionFactory
	private SqlSessionFactory sqlSessionFactory;
	//构造方法，传入sqlSessionFactory
	public ProductDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public Product getProductById(Integer id) throws Exception {
		//sqlSession在方法体内获得，用完关闭
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Product product = sqlSession.selectOne("org.mybatis.test.ProductMapper.getProductById", id);
		sqlSession.close();
		return product;
	}

}
