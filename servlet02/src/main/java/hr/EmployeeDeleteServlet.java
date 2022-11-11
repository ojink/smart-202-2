package hr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HrDAO;

@WebServlet("/employee/emp_delete")
public class EmployeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비지니스로직:선택한 사원정보를 DB에서 삭제
		//선택한 사원정보 삭제 메소드 호출
		int id = Integer.parseInt( request.getParameter("id") );
		HrDAO dao = new HrDAO();
		dao.employee_delete( id );
		
		//프리젠테이션로직:응답화면연결: 목록화면
		response.sendRedirect("emp_list");
	}

}
