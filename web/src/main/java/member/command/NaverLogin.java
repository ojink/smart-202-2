package member.command;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import common.CommonUtility;

public class NaverLogin implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//네이버 로그인 연동 URL 생성하기
		//https://nid.naver.com/oauth2.0/authorize?response_type=code
		//&client_id=CLIENT_ID
		//&state=STATE_STRING
		//&redirect_uri=CALLBACK_URL
		//상태 토큰값 생성하기: 랜덤문자열로 생성
		String state = UUID.randomUUID().toString();
		request.getSession().setAttribute("state", state);
		
		StringBuffer url = new StringBuffer(
			"https://nid.naver.com/oauth2.0/authorize?response_type=code");
		url.append("&client_id=")
				.append( (String)request.getAttribute("naver_id") );
		url.append("&state=").append(state);
		url.append("&redirect_uri=")
			.append( CommonUtility.appUrl(request) )
			.append("/navercallback.mb");
		request.setAttribute("url", url.toString());
	}

}
