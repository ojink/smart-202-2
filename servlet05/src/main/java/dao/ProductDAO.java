package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.ProductDTO;
import mybatis.MybatisFactory;

public class ProductDAO {
	private SqlSession sql;
	
	public List<ProductDTO> product_list() {
		connect();
		List<ProductDTO> list = sql.selectList("product.product_list");
		return list;
	}
	
	
	private void connect() {
		SqlSessionFactory factory = MybatisFactory.getInstance();
		sql = factory.openSession(true);
	}
}
