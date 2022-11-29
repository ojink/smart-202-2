package hr.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import hr.EmployeeDTO;
import hr.HrDAO;

public class EmployeeUpdate implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//화면에서 변경입력한 정보를 DB에 변경저장한다
		//화면에서 입력한 정보를 수집 -> 변경저장메소드 호출
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployee_id(
				Integer.parseInt( request.getParameter("employee_id")) );
		dto.setLast_name( request.getParameter("last_name"));
		dto.setFirst_name( request.getParameter("first_name"));
		dto.setEmail( request.getParameter("email"));
		dto.setPhone_number( request.getParameter("phone_number"));
		dto.setDepartment_id( 
				Integer.parseInt( request.getParameter("department_id")) );
		dto.setJob_id( request.getParameter("job_id") );
		dto.setSalary( 
				Integer.parseInt(request.getParameter("salary") ) );
		//String -> int
		dto.setManager_id( 
				Integer.parseInt(request.getParameter("manager_id") ) );
		//String -> Date
		dto.setHire_date( 
				Date.valueOf( request.getParameter("hire_date") ) );
		
		HrDAO dao = new HrDAO();
		dao.employee_update(dto);
	}

}
