package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;

public class MemberLogout implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//세션에 있는 로그인정보를 삭제한다
		request.getSession().removeAttribute("loginInfo");
		request.setAttribute("url", request.getContextPath());
	}

}
