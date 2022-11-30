package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import member.MemberDAO;
import member.MemberDTO;

public class MemberLogin implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//화면에서 입력한 아이디,비번이 일치하는 회원정보를 DB에서 조회해온다
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.login(id, pw);
		
		//화면에서 출력할 수 있도록 attribute로 담는다
		request.getSession().setAttribute("loginInfo", dto);
		try {
		response.getWriter().print( dto==null ? false : true );
		}catch(Exception e) {}
	}

}
