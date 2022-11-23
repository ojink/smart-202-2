package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.ProductDTO;
import mybatis.MybatisFactory;

public class ProductDAO {
	private SqlSession sql;
	
	//선택한 상품정보 조회 메소드
	public ProductDTO product_info(int num) {
		connect();
		//매퍼 쿼리태그의 resultType에 해당하는 타입으로 선언
		ProductDTO dto = sql.selectOne("product.product_info", num);
		return dto;
	}
	
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
