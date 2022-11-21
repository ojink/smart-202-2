package dao;

import java.sql.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.MybatisFactory;

public class TestDAO {
	private SqlSession sql;
	/*
	PreparedStatement 에서의  메소드와 SqlSession 에서의 메소드
	executeQuery() : selectOne, selectList("매퍼의namespace.쿼리태그id") 
	executeUpdate() : update, insert, delete 
	*/
	
	public Date select_today() {
		connect();
		Date today = sql.selectOne("test.select_today");
		return today;
	}
	
	public String select_now() {
		connect();
		String now = sql.selectOne("test.select_now");
		return now;
	}
	
	//회원수 조회메소드
	public int user_count() {
		connect();
		int count = sql.selectOne("test.user_count");
		return count;
	}
	
	
	void connect() {
		SqlSessionFactory factory = MybatisFactory.getInstance();
		sql = factory.openSession( true );
/*		
		String resource = "mybatis/config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory 
				= new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession( true ); //auto commit
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
*/		
	}
	
	/*
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//오늘 날짜를 조회하는 메소드
	public Date select_today() {
		Date today = null;  //java.sql.Date
		connect();
		String sql = "select sysdate from dual";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next(); //커서이동
			today = rs.getDate("sysdate");			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			disconnect();
		}
		return today;
	}
	
	void connect() {
		try {
			//context.xml 에 선언한 Resource 찾기
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/smart");
			conn = ds.getConnection();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//쿼리문실행 후 자원회수하기
	void disconnect() {
		if( rs!=null ) {  try { rs.close(); }catch(Exception e) {} }
		if( ps!=null ) {  try { ps.close(); }catch(Exception e) {} }
		if( conn!=null ) {  try { conn.close(); }catch(Exception e) {} }
	}
	*/
}
