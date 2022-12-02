package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.Command;
import common.CommonUtility;
import member.MemberDAO;
import member.MemberDTO;

public class KakaoCallback implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		
		if( code != null ) {
			
//			curl -v -X POST "https://kauth.kakao.com/oauth/token" \
//			 -H "Content-Type: application/x-www-form-urlencoded" \
//			 -d "grant_type=authorization_code" \
//			 -d "client_id=${REST_API_KEY}" \
//			 --data-urlencode "redirect_uri=${REDIRECT_URI}" \
//			 -d "code=${AUTHORIZE_CODE}"
			//접근토큰 발급 요청
			StringBuffer url = new StringBuffer(
				"https://kauth.kakao.com/oauth/token?grant_type=authorization_code");
			url.append("&client_id=")
				.append( (String)request.getAttribute("kakao_id") );
			url.append("&code=").append(code);
			
			String tokens = CommonUtility.requestAPI( url.toString() );
			JSONObject json = new JSONObject( tokens );
			String token_type  = json.getString("token_type");
			String access_token  = json.getString("access_token");
			
			//토큰을 사용해 사용자프로필정보를 요청
			//GET/POST /v2/user/me HTTP/1.1
			//Host: kapi.kakao.com
			//Authorization: Bearer ${ACCESS_TOKEN}/KakaoAK ${APP_ADMIN_KEY}
//			curl -v -X GET "https://kapi.kakao.com/v2/user/me" \
//			  -H "Authorization: Bearer ${ACCESS_TOKEN}"
			url = new StringBuffer("https://kapi.kakao.com/v2/user/me");
			String profile = CommonUtility.requestAPI(
					url.toString(), token_type +" "+access_token);
			
			json = new JSONObject( profile );
			if( ! json.isEmpty() ) {
				
				MemberDTO dto = new MemberDTO();
				dto.setSocial("K");
				dto.setUserid( json.get("id").toString() ); //"id":123456789,
				
				json = json.getJSONObject("kakao_account");
				dto.setName( json.has("name") 
							? json.getString("name") : "무명씨");
				dto.setEmail( json.has("email") 
								? json.getString("email") : "");
				// female(여) / male(남)
				dto.setGender(
					json.has("gender") ?
						(json.getString("gender").equals("female") ? "여" : "남")
						: "남"	
					);
				dto.setPhone( json.has("phone_number") 
								? json.getString("phone_number") : "");

				if( json.has("profile") ) {	
					json = json.getJSONObject("profile");
					dto.setProfile( 
						json.has("profile_image_url") 
						? json.getString("profile_image_url") : "");
				}
				MemberDAO dao = new MemberDAO();
				if( dao.idExist( dto.getUserid() )==1 ) {
					dao.member_update(dto);
				}else {
					dao.member_insert(dto);
				}
				
				request.getSession().setAttribute("loginInfo", dto);
				
			}			
		}		
	}

}



