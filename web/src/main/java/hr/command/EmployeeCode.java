package hr.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import hr.DepartmentDTO;
import hr.HrDAO;
import hr.JobDTO;
import hr.ManagerDTO;

public class EmployeeCode implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//전체 부서목록, 전체 업무목록, 관리자로 지정할 전체사원목록을
		//DB에서 조회해온다
		HrDAO dao = new HrDAO();
		List<DepartmentDTO> departments = dao.department_list_all();
		List<JobDTO> jobs = dao.job_list_all();
		List<ManagerDTO> managers = dao.manager_list_all();
		
		//화면에서 출력할 수 있도록 request에 담는다
		request.setAttribute("jobs", jobs);
		request.setAttribute("departments", departments);
		request.setAttribute("managers", managers);
	}

}
