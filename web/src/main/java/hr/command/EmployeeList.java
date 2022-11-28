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
		int department_id = -1;  //선택한 부서가 없는 경우
		if( request.getParameter("department_id") != null) {			
			department_id = Integer.parseInt(
								request.getParameter("department_id") );
		}
		
		List<EmployeeDTO> list = dao.employee_list(department_id);
		/*
		//전체사원조회
		if( department_id==-1)
			list = dao.employee_list();
		else
		//선택한 부서의 사원조회
			list = dao.employee_list(department_id);
		*/
		
		//부서별 사원정보를 조회할 수 있도록 
		//DB에서 부서목록을 조회해온다
		List<DepartmentDTO> departments = dao.department_list();
		
		//화면에서 출력할 수 있도록 request에 attribute 로 담는다
		request.setAttribute("list", list);
		request.setAttribute("departments", departments);
		//선택한 부서정보를 request에 담는다
		request.setAttribute("department_id", department_id);
	}

}
