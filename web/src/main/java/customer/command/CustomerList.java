package customer.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import customer.CustomerDAO;
import customer.CustomerDTO;

public class CustomerList implements Command{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//DB에서 전체 고객목록을 조회해온다
		CustomerDAO dao = new CustomerDAO();
		List<CustomerDTO> list = dao.customer_list();
		
		//화면에 출력할 수 있도록 request에 attribute로 담는다
		request.setAttribute("list", list);
		request.getSession().setAttribute("category", "cu");
	}

}




