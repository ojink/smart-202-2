package command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TestDAO;

public class TestCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스로직
		//DB에서 데이터를 조회해온다: DB연결 -> 조회메소드호출
		TestDAO dao = new TestDAO();
		Date today = dao.select_today(); //java.sql.Date
		
		//현재시각 정보 조회메소드 호출
		String now = dao.select_now();
		
		//회원수 조회메소드 호출
		int count = dao.user_count();
		
		//조회해온 정보를 화면에서 출력할 수 있도록
		//request 에 attribute로 데이터를 담는다.
		request.setAttribute("today", today);
		request.setAttribute("now", now);
		request.setAttribute("users", count);
	}

}
