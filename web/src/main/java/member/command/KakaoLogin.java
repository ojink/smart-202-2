package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import common.CommonUtility;

public class KakaoLogin implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//https://kauth.kakao.com/oauth/authorize?response_type=code
		//&client_id=${REST_API_KEY}
		//&redirect_uri=${REDIRECT_URI}
		
		StringBuffer url = new StringBuffer(
			"https://kauth.kakao.com/oauth/authorize?response_type=code");
		url.append("&client_id=")
			.append( (String)request.getAttribute("kakao_id") );
		url.append("&redirect_uri=")
			.append( CommonUtility.appUrl(request) )
			.append("/kakaocallback.mb");
		request.setAttribute("url", url.toString());
	}

}
