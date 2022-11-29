package hr;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.HrFactory;

public class HrDAO {
	private SqlSession sql;
	private void connect() {
		SqlSessionFactory factory = HrFactory.getInstance();
		sql = factory.openSession(true);
	}
	
	//CRUD(Create, Read, Update, Delete)
	//신규사원등록
	public void employee_regist(EmployeeDTO dto){
	}
	
	//전체사원목록조회
	public List<EmployeeDTO> employee_list() {
		connect();
		List<EmployeeDTO> list = sql.selectList("hr.list");
		return list;
	}
	
	//선택한 부서의 사원조회
	public List<EmployeeDTO> employee_list(int department_id) {
		connect();
		List<EmployeeDTO> list = sql.selectList("hr.list", department_id);
		sql.close();
		return list;
	}
	
	//전체 부서목록
	public List<DepartmentDTO> department_list_all() {
		connect();
		List<DepartmentDTO> list = sql.selectList("hr.department_list_all");
		return list;
	}
	
	//전체 업무목록 
	public List<JobDTO> job_list_all() {
		connect();
		List<JobDTO> list = sql.selectList("hr.job_list_all");
		return list;
	}
	
	//관리자로 지정할 전체사원목록
	public List<ManagerDTO> manager_list_all() {
		connect();
		List<ManagerDTO> list = sql.selectList("hr.manager_list_all");
		return list;
	}

	//선택한 사원정보조회
	public EmployeeDTO employee_info(int id) {
		connect();
		EmployeeDTO dto = sql.selectOne("hr.info", id);
		return dto;
	}
	
	//사원이 소속되어 있는 부서목록 조회
	public List<DepartmentDTO> department_list() {
		connect();
		List<DepartmentDTO> list = sql.selectList("hr.department_list");
		return list;
	}
	
	//선택한 사원정보변경
	public void employee_update(EmployeeDTO dto) {
		connect();
		sql.update("hr.update", dto);
		sql.close();
	}
	
	
	//선택한 사원정보삭제
	public void employee_delete(int employee_id) {
		
	}
	
}
