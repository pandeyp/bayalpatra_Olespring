/**
 * 
 */
package com.lbef.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.lbef.dao.EmployeeDao;
import com.lbef.daoimpl.LeaveDaoImpl.AllLeaveMapper;
import com.lbef.domain.Employee;
import com.lbef.domain.Leave;
import com.lbef.domain.SalaryReport;
import com.lbef.service.DepartmentService;
import com.lbef.service.DesignationService;

/**
 * @author Prasanna
 * 
 */
public class EmployeeDaoImpl extends SimpleJdbcDaoSupport implements
		EmployeeDao {

	DesignationService designationService;
	DepartmentService departmentService;

	@Override
	public void addEmployee(Employee employee) throws Exception {
		try {
			String insertEmployee = "insert into employee (first_name,last_name,middle_name,date_of_birth,marital_status,gender,permanent_address,temporary_address,home_phone,mobile,email,join_date,status,department_id,designation_id,username) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			getSimpleJdbcTemplate().update(
					insertEmployee,
					new Object[] { employee.getFirst_name(),
							employee.getLast_name(), 
							employee.getMiddle_name(),
							employee.getDate_of_birth(),
							employee.getMarital_status(), 
							employee.getGender(),
							employee.getPermanent_address(),
							employee.getTemporary_address(),
							employee.getHome_phone(), 
							employee.getMobile(),
							employee.getEmail(), 
							employee.getJoin_date(),
							employee.getStatus(), 
							employee.getDepartment_id(),  ////*************check in update this works but here it was only
							employee.getDesignation_id(),  // employee.getDepartment_id()
							employee.getUsername() });
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		try {
			List<Employee> employeeList = getSimpleJdbcTemplate().query(
					"select * from employee where status !='Terminated' ", new AllEmployeeMapper());
			return employeeList;
		} catch (DataAccessException e) {
			throw e;
		}

	}

	public class AllEmployeeMapper implements ParameterizedRowMapper<Employee> {
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setId(rs.getInt("id"));
			employee.setFirst_name(rs.getString("first_name"));
			employee.setLast_name(rs.getString("last_name"));
			employee.setMiddle_name(rs.getString("middle_name"));
			employee.setDate_of_birth(rs.getString("date_of_birth"));
			employee.setMarital_status(rs.getString("marital_status"));
			employee.setGender(rs.getString("gender"));
			employee.setPermanent_address(rs.getString("permanent_address"));
			employee.setTemporary_address(rs.getString("temporary_address"));
			employee.setHome_phone(rs.getString("home_phone"));
			employee.setMobile(rs.getString("mobile"));
			employee.setEmail(rs.getString("email"));
			employee.setJoin_date(rs.getString("join_date"));
			employee.setStatus(rs.getString("status"));
			employee.setDepartment_id(rs.getInt("department_id"));
			employee.setDesignation_id(rs.getInt("designation_id"));
			employee.setUsername(rs.getString("username"));
			return employee;
		}
	}
	
	public class SalaryRowMapper implements ParameterizedRowMapper<SalaryReport> {
		public SalaryReport mapRow(ResultSet rs, int rowNum) throws SQLException {
			SalaryReport salaryReport = new SalaryReport();
			salaryReport.setFirst_name(rs.getString("first_name"));
			salaryReport.setLast_name(rs.getString("last_name"));
			salaryReport.setDesignation(rs.getString("job_title_name"));
			salaryReport.setBasic_salary(rs.getDouble("basic_salary"));
			salaryReport.setSalary_month(rs.getString("salary_month"));
			return salaryReport;
		}
	}

	@Override
	public Employee loadEmployee(int id) {
		try {
			Employee employee = getSimpleJdbcTemplate().queryForObject(
					"select * from employee where id=?",
					new AllEmployeeMapper(), id);
			return employee;
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@Override
	public void updateEmployee(Employee employee) {
		try {
			getSimpleJdbcTemplate()
					.update("update employee set first_name=?,last_name=?,middle_name=?,date_of_birth=?,marital_status=?,gender=?,permanent_address=?,temporary_address=?,home_phone=?,mobile=?,email=?,join_date=?,status=?,department_id=?,designation_id=?,username=? where id=?",
							new Object[] { employee.getFirst_name(),
									employee.getLast_name(),
									employee.getMiddle_name(),
									employee.getDate_of_birth(),
									employee.getMarital_status(),
									employee.getGender(),
									employee.getPermanent_address(),
									employee.getTemporary_address(),
									employee.getHome_phone(),
									employee.getMobile(), employee.getEmail(),
									employee.getJoin_date(),
									employee.getStatus(),
									employee.getDepartment_id(),
									employee.getDesignation_id(),
									employee.getUsername(), employee.getId() });
		} catch (DataAccessException e) {
			throw e;
		}

	}

	@Override
	public void deleteEmployee(int id) {
		try {
			getSimpleJdbcTemplate().update("delete from employee where id=?",
					new Object[] { id });
		} catch (DataAccessException e) {
			throw e;
		}

	}

	@Override
	public Employee findEmployee(String userName) {
		Employee emp = null;
		try {
			emp = getSimpleJdbcTemplate().queryForObject(
					"select * from employee where username=?",
					new AllEmployeeMapper(), new Object[] { userName });
		} catch (DataAccessException e) {
			throw e;
		}
		return emp;
	}
	
	@Override
	public String findPassword(int id) {
		String pwd = null;
		try {
			pwd = getSimpleJdbcTemplate().queryForObject(
					"select password from user where employee_id=?",
					String.class, new Object[] { id });
		} catch (DataAccessException e) {
			throw e;
		}
		return pwd;
	}
	
	@Override
	public List<Employee> getAllTermedEmployee() {
		try {
			List<Employee> empList = getSimpleJdbcTemplate().query(
					"select * from employee  where status='Terminated'",
					new AllEmployeeMapper());
			return empList;
		} catch (DataAccessException e) {
			throw e;
		}
	}
	
	@Override
	public List<SalaryReport> getSalaryReport(){
		List<SalaryReport> salaryReportList = null;
		try {
			
			salaryReportList = getSimpleJdbcTemplate().query("SELECT e.first_name, e.last_name, d.job_title_name, s.basic_salary, MONTH(CURDATE()) AS salary_month  FROM employee e, designation d, salary s WHERE e.designation_id = d.id AND e.designation_id = s.designation_id", new SalaryRowMapper());
			return salaryReportList;
		} catch (DataAccessException e) {
			throw e;
		}
	}

	/**
	 * @return the designationService
	 */
	public DesignationService getDesignationService() {
		return designationService;
	}

	/**
	 * @param designationService
	 *            the designationService to set
	 */
	public void setDesignationService(DesignationService designationService) {
		this.designationService = designationService;
	}

	/**
	 * @return the departmentService
	 */
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	/**
	 * @param departmentService
	 *            the departmentService to set
	 */
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}




}
