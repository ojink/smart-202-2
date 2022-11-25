package customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import customer.CustomerDAO;
import customer.CustomerDTO;

public class CustomerUpdate implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//변경된 고객정보를 DB에 저장한다
		//:1.화면에서 입력한 정보를 수집한다
		CustomerDTO dto = new CustomerDTO();
		dto.setId( Integer.parseInt(request.getParameter("id")) );
		dto.setName( request.getParameter("name") );
		dto.setGender( request.getParameter("gender") );
		dto.setEmail( request.getParameter("email") );
		dto.setPhone( request.getParameter("phone") );
		
		// 2.수집한 정보로 DB에 변경저장처리: 변경저장메소드 호출
		CustomerDAO dao = new CustomerDAO();
		dao.customer_update(dto);
	}

}
