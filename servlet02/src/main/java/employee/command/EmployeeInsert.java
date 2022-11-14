package employee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import dao.HrDAO;
import dto.EmployeeDTO;

public class EmployeeInsert implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//화면에서 입력한 사원정보를 DB에 저장
		//1.화면에서 입력한 사원정보를 수집: DTO에 담기
		EmployeeDTO dto = new EmployeeDTO();
		dto.setLast_name( request.getParameter("last_name") );
		dto.setFirst_name( request.getParameter("first_name") );
		dto.setEmail( request.getParameter("email") );
		dto.setJob_id( request.getParameter("job_id") );
		//String -> int
		dto.setDepartment_id( 
			Integer.parseInt(request.getParameter("department_id")) );
		dto.setSalary( Integer.valueOf(request.getParameter("salary")) );
		
		//2.수집한 정보를 DB저장: DB연결->저장처리메소드 호출
		HrDAO dao = new HrDAO();
		dao.employee_insert(dto);
		
	}

}
