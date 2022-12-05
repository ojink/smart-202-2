package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import common.CommonUtility;
import member.MemberDTO;

public class MemberLogout implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		MemberDTO dto
		= (MemberDTO)request.getSession().getAttribute("loginInfo");
		String social = dto.getSocial();
		
		//세션에 있는 로그인정보를 삭제한다
		request.getSession().removeAttribute("loginInfo");
		request.setAttribute("url", request.getContextPath());
		
		//카카오 로그인한 경우에만 해당: social:K
		if( social!=null && social.equals("K")  ) {
			//"https://kauth.kakao.com/oauth/logout
			//?client_id=${YOUR_REST_API_KEY}
			//&logout_redirect_uri=${YOUR_LOGOUT_REDIRECT_URI}"
			
			StringBuffer url = new StringBuffer(
				"https://kauth.kakao.com/oauth/logout");
			url.append("?client_id=")
					.append( (String)request.getAttribute("kakao_id") );
			url.append("&logout_redirect_uri=")
					.append( CommonUtility.appUrl(request) );
			request.setAttribute("url", url.toString());
		}
	}

}







