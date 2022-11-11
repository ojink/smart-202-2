package hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HrDAO;
import dto.EmployeeDTO;

@WebServlet("/employee/emp_list")
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		
		out.print("<div><a href='../'>홈으로</a></div>");
		out.print("<div><a href='index.html'>사원관리</a></div>");
		out.print("<hr>");
		
		out.print("<h2>사원목록</h2>");
		out.print("<table border='1'>");
		out.print("<tr><th>사번</th><th>사원명</th>"
					+ "<th>부서</th><th>급여</th><th>입사일자</th><th></th></tr>");
/*		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//드라이버로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe"
					, "hr", "0000");
			String sql
			= "select * from employees";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
			
				out.printf("<tr><td>%d</td><td>%s</td>"
					+ "<td>%d</td><td>%d</td><td>%s</td></tr>"
					, rs.getInt("employee_id")
					, rs.getString("last_name")+ " " + rs.getString("first_name")
					, rs.getInt("department_id")
					, rs.getInt("salary")
					, rs.getDate("hire_date"));
			}
			
		}catch(Exception e) {
		}finally {
			if( rs!=null ) { try { rs.close(); }catch(Exception e) {} }
			if( ps!=null ) { try { ps.close(); }catch(Exception e) {} }
			if( conn!=null ) { try { conn.close(); }catch(Exception e) {} }
		}
*/
		HrDAO dao = new HrDAO();
		ArrayList<EmployeeDTO> list = dao.employee_list();
		for( EmployeeDTO dto : list ) {
			
			out.printf("<tr><td><a href='emp_info?id=%d'>%d</a></td><td>%s</td>"
					+ "<td>%s</td><td>%d</td><td>%s</td>"
					+ "<td><a href='emp_delete?id=%d'>정보삭제</a></tr>"
					, dto.getEmployee_id()
					, dto.getEmployee_id()
					, dto.getName()
					, dto.getDepartment_name()
					, dto.getSalary()
					, dto.getHire_date()
					, dto.getEmployee_id()
					);
		}
		
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		
	}

}
