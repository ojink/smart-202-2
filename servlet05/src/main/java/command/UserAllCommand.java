package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dto.UserDTO;

public class UserAllCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//DB에서 전체 사용자이름을 조회해온다
		//DB연결 -> 전체 사용자이름을 조회 메소드 호출
		UserDAO dao = new UserDAO();
		List<String> list = dao.select_name_all();
		List<UserDTO> user_list = dao.select_user_list();
		
		//화면에 출력할 수 있도록 request 에 attribute 로 담는다
		request.setAttribute("list", list);
		request.setAttribute("user_list", user_list);
		
	}

}
