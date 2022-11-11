package employee.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import dao.HrDAO;
import dto.EmployeeDTO;

public class EmployeeSelect implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직처리: 사원정보를 DB에서 조회해온다
		HrDAO dao = new HrDAO();
		ArrayList<EmployeeDTO> list = dao.employee_list();
		//조회해온 데이터를 request 에 담는다
		request.setAttribute("list", list);
	}

}
