package junit;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import pojo.Product;

import com.mybatis.dao.ProductDao;
import com.mybatis.dao.daoImpl.ProductDaoImpl;

public class ProductDaoImplTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testGetProductById() {
		ProductDao productDao = new ProductDaoImpl(sqlSessionFactory);
		try {
			Product product = productDao.getProductById(23);
			System.out.println(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
