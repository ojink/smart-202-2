package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.Command;
import common.CommonUtility;
import member.MemberDAO;
import member.MemberDTO;

public class NaverCallback implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
//		Callback 응답 정보
//		API 요청 성공시 : http://콜백URL/redirect?code={code값}&state={state값}
//		API 요청 실패시 : http://콜백URL/redirect?state={state값}&error={에러코드값}&error_description={에러메시지}
		String state = request.getParameter("state");
		String code = request.getParameter("code");
		//code: 성공이면 값이 있고, 실패하면 null
		
		//세션에 저장해둔 state 와 파라미터로 받은 state 가 같은지 확인
		String session_state 
			= (String )request.getSession().getAttribute("state");
		if( state.equals(session_state) && code != null ) {
			
			//접근 토큰 발급 요청
			// 전달받은 'code' 값을 이용하여 '접근토큰발급API'를 호출하게 되면 
			// API 응답으로 접근토큰에 대한 정보를 받을 수 있습니다
			//https://nid.naver.com/oauth2.0/token?grant_type=authorization_code
			//&client_id=jyvqXeaVOVmV
			//&client_secret=527300A0_COq1_XV33cf
			//&code=EIc5bFrl4RibFls1
			//&state=9kgsGTfH4j7IyAkg  
			StringBuffer url 
				= new StringBuffer("https://nid.naver.com/oauth2.0/token?grant_type=authorization_code");
			url.append("&client_id=")
					.append((String)request.getAttribute("naver_id"));
			url.append("&client_secret=")
					.append((String)request.getAttribute("naver_secret"));
			url.append("&code=").append( code );
			url.append("&state=").append( state );
		
			//String --> JSON
			String tokens = CommonUtility.requestAPI( url.toString() );
//			{
//			    "access_token":"AAAAQosjWDJieBiQZc3to9YQp6HDLvrmyKC+6+iZ3gq7qrkqf50ljZC+Lgoqrg",
//			    "refresh_token":"c8ceMEJisO4Se7uGisHoX0f5JEii7JnipglQipkOn5Zp3tyP7dHQoP0zNKHUq2gY",
//			    "token_type":"bearer",
//			    "expires_in":"3600"
//			}
			JSONObject json = new JSONObject(tokens);
			String access = json.getString("access_token");
			String type = json.getString("token_type");
			
			//접근 토큰을 이용하여 프로필 API 호출하기
			url = new StringBuffer("https://openapi.naver.com/v1/nid/me");
			String profile = CommonUtility.requestAPI(
								url.toString(), type + " " + access);
			json = new JSONObject( profile );
			if( json.getString("resultcode").equals("00") ) {
				
				json = json.getJSONObject("response");
				MemberDTO dto = new MemberDTO();
				dto.setSocial("N");
				dto.setUserid( json.getString("id") );
				dto.setEmail( json.getString("email"));
				dto.setName( json.getString("name") );
				if( dto.getName().isEmpty() ) {
					dto.setName( json.getString("nickname") );
				}
				dto.setProfile( json.has("profile_image")
						? json.getString("profile_image") : "" );
				//F여/M남
				dto.setGender( 
					json.getString("gender").equals("F") ? "여"  : "남");
				if( json.has("birthyear") ) {
					dto.setBirth( json.getString("birthyear") + "-" 
								+ json.getString("birthday") );
				}
				dto.setPhone( json.getString("mobile"));
				
				//DB에 해당 id 가 존재하는지 파악
				MemberDAO dao = new MemberDAO();
				if( dao.idExist( dto.getUserid() )==0 ) {
					//네이버로 로그인이 처음인 경우: insert
					dao.member_insert(dto);
				}else {
					//네이버로 로그인한 적이 있는 경우: update
					dao.member_update(dto);
				}
				request.getSession().setAttribute("loginInfo", dto);
			}
		}
	}

}
