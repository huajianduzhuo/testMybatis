package junit;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import pojo.Category;
import pojo.Product;

import com.mybatis.mapper.ProductMapper;

public class ProductMapperTest {

	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testGetProductByName() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		List<Product> list = null;
		try {
			Product product = new Product();
			product.setPrice(1000.00f);
			list = productMapper.getProductByName(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
		sqlSession.close();
	}
	
	@Test
	public void getProductAndPicture() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		List<Product> list = null;
		try {
			list = productMapper.getProductAndPicture();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
		sqlSession.close();
	}
	
	@Test
	public void getProductCateLazyLoading() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		List<Product> list = null;
		try {
			list = productMapper.getProductCateLazyLoading();
			System.out.println("-------------------------------------------");
			for(Product product : list){
				Category category = product.getCategory();
				System.out.println(category.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
		sqlSession.close();
	}

}
