package customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import customer.CustomerDAO;
import customer.CustomerDTO;

public class CustomerInsert implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//화면에서 입력한 정보를 DB에 신규저장한다
		//화면에서 입력한 정보 수집
		CustomerDTO dto = new CustomerDTO();
		dto.setName( request.getParameter("name") );
		dto.setGender( request.getParameter("gender") );
		dto.setEmail( request.getParameter("email") );
		dto.setPhone( request.getParameter("phone") );
		
		//-> DB에 신규저장 메소드 호출
		CustomerDAO dao = new CustomerDAO();
		dao.customer_insert(dto);
	}

}
