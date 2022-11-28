package hr.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import hr.EmployeeDTO;
import hr.HrDAO;

public class EmployeeInfo implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt( request.getParameter("id") );
		
		//선택한 사원정보를 DB에서 조회해온다
		HrDAO dao = new HrDAO();
		EmployeeDTO dto = dao.employee_info(id);
		
		//화면에서 출력할 수 있도록 request에 attribute로 담는다
		request.setAttribute("dto", dto);
	}

}
