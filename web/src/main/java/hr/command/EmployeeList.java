package hr.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import hr.DepartmentDTO;
import hr.EmployeeDTO;
import hr.HrDAO;

public class EmployeeList implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//DB에서 사원목록을 조회해온다
		HrDAO dao = new HrDAO();
		List<EmployeeDTO> list = dao.employee_list();
		
		//부서별 사원정보를 조회할 수 있도록 
		//DB에서 부서목록을 조회해온다
		List<DepartmentDTO> departments = dao.department_list();
		
		//화면에서 출력할 수 있도록 request에 attribute 로 담는다
		request.setAttribute("list", list);
		request.setAttribute("departments", departments);
	}

}
