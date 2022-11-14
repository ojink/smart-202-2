package employee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import dao.HrDAO;

public class EmployeeDelete implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직: 선택한 사원의 정보를 DB에서 삭제
		//DB연결 -> 사원정보삭제 메소드 호출
		HrDAO dao = new HrDAO();
		dao.employee_delete( 
			Integer.parseInt( request.getParameter("id")) );
	}

}
