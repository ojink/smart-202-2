package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.UserDTO;
import mybatis.MybatisFactory;

public class UserDAO {
	private SqlSession sql;
	
	//선택한 사용자의 정보 조회 메소드
	public UserDTO select_user_info(String id) {
		connect();
		UserDTO dto = sql.selectOne("user.user_info", id);
		return dto;
	}
	
	//전체 사용자정보를 조회 메소드
	public List<UserDTO> select_user_list() {
		connect();
		List<UserDTO> list = sql.selectList("user.user_list");
		return list;
	}
	
	
	//전체 사용자이름을 조회 메소드
	public List<String> select_name_all() {
		connect();
		List<String> list = sql.selectList("user.name_all");
		return list;
	}
	
	
	//이름 조회 메소드
	public String select_name() {
		connect();
		String name = sql.selectOne("user.user_name");
		return name;
	}
	//Money  조회 메소드
	public int select_money() {
		connect();
		int money = sql.selectOne("user.user_money");
		return money;
	}
	
	void connect() {
		SqlSessionFactory factory
			= MybatisFactory.getInstance();
		sql = factory.openSession(true);
	}
}
