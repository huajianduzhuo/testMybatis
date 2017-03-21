package junit;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import pojo.Product;
import pojo.User;

public class Test1 {
	
	@Test
	public void getProductById(){
		SqlSession sqlSession = null;
		try {
			InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			//第一个参数为namespace+"."+id
			Product product = sqlSession.selectOne("org.mybatis.test.ProductMapper.getProductById", 20);
			System.out.println(product);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void getProductByName(){
		SqlSession sqlSession = null;
		try {
			InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			//第一个参数为namespace+"."+id
			List<Product> products = sqlSession.selectList("org.mybatis.test.ProductMapper.getProductByName", "岑");
			System.out.println(products);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void addProduct(){
		SqlSession sqlSession = null;
		try {
			InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			Product product = new Product();
			product.setName("岑我");
			product.setDescription("我站岑我");
			product.setPrice(99.99f);
			product.setProduction_date(new Date());
			product.setCat_id(4);
			//第一个参数为namespace+"."+id
			sqlSession.insert("org.mybatis.test.ProductMapper.addProduct", product);
			System.out.println("商品id是：" + product.getId());
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void deleteProduct(){
		SqlSession sqlSession = null;
		try {
			InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			//第一个参数为namespace+"."+id
			sqlSession.delete("org.mybatis.test.ProductMapper.deleteProduct", 25);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void modifyProduct(){
		SqlSession sqlSession = null;
		try {
			InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			Product product = new Product();
			product.setId(23);
			product.setName("岑小黄");
			product.setDescription("岑小黄");
			product.setPrice(99.99f);
			product.setProduction_date(new Date());
			product.setCat_id(3);
			//第一个参数为namespace+"."+id
			sqlSession.update("org.mybatis.test.ProductMapper.modifyProduct", product);
			System.out.println(product.toString());
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void addUser(){
		SqlSession sqlSession = null;
		try {
			InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			User user = new User();
			user.setUsername("aaa123");
			user.setPassword("123456");
			user.setNick_name("花见酒");
			//第一个参数为namespace+"."+id
			sqlSession.insert("org.mybatis.test.UserMapper.addUser", user);
			System.out.println(user.toString());
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}

}
