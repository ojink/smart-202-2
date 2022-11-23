package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dto.UserDTO;

public class UserInfoCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//선택한 사용자의 정보를 DB에서 조회해온다
		//: 사용자의 정보 조회 메소드 호출
		String id = request.getParameter("id");
		UserDAO dao = new UserDAO();
		UserDTO dto = dao.select_user_info(id);
		
		//화면에 출력할 수 있도록 request에 attribute 로 담는다
		request.setAttribute("dto", dto);
	}

}
