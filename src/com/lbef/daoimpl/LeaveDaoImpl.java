/**
 * 
 */
package com.lbef.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.lbef.dao.LeaveDao;
import com.lbef.domain.Leave;
import com.lbef.service.EmployeeService;

/**
 * @author Prasanna
 * 
 */
public class LeaveDaoImpl extends SimpleJdbcDaoSupport implements LeaveDao {

	EmployeeService employeeService;

	@Override
	public void addLeave(Leave leave) throws Exception {
		try {
			String insertLeave = "insert into employee_leave (leave_type,from_date,to_date,leave_difference,status,employee_id) values (?,?,?,?,?,?) ";
			getSimpleJdbcTemplate().update(
					insertLeave,
					new Object[] { leave.getLeave_type(), leave.getFrom_date(),
							leave.getTo_date(), leave.getLeave_difference(),
							leave.getStatus(), leave.getEmployee_id() });
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Leave> getAllUnapprovedLeave() {
		try {
			List<Leave> leaveList = getSimpleJdbcTemplate().query(
					"select * from employee_leave where status='Unapproved'",
					new AllLeaveMapper());
			return leaveList;
		} catch (DataAccessException e) {
			throw e;
		}

	}

	@Override
	public List<Leave> getAllApprovedLeave() {
		try {
			List<Leave> leaveList = getSimpleJdbcTemplate().query(
					"select * from employee_leave  where status='Approved'",
					new AllLeaveMapper());
			return leaveList;
		} catch (DataAccessException e) {
			throw e;
		}

	}

	public class AllLeaveMapper implements ParameterizedRowMapper<Leave> {
		public Leave mapRow(ResultSet rs, int rowNum) throws SQLException {
			Leave leave = new Leave();
			leave.setId(rs.getInt("id"));
			leave.setLeave_type(rs.getString("leave_type"));
			leave.setFrom_date(rs.getString("from_date"));
			leave.setTo_date(rs.getString("to_date"));
			leave.setLeave_difference(rs.getDouble("leave_difference"));
			leave.setStatus(rs.getString("status"));
			leave.setApproved_by(rs.getString("approved_by"));
			leave.setEmployee_id(rs.getInt("employee_id")); // CHECK for
															// employee!!!

			return leave;
		}
	}

	@Override
	public Leave loadLeave(int id) {
		try {
			Leave leave = getSimpleJdbcTemplate().queryForObject(
					"select * from employee_leave where id=?",
					new AllLeaveMapper(), id);
			return leave;
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@Override
	public void updateLeave(Leave leave) {
		try {
			getSimpleJdbcTemplate()
					.update("update employee_leave set leave_type=?, from_date=?, to_date=?, leave_difference=?, status=?, employee_id=? where id=?",
							new Object[] { leave.getLeave_type(),
									leave.getFrom_date(), leave.getTo_date(),
									leave.getLeave_difference(),
									leave.getStatus(),
									/* leave.getApproved_by(), */
									leave.getEmployee_id(), // //CHECK FOR
															// EMPLOYEE!!!
									leave.getId() });
		} catch (DataAccessException e) {
			throw e;
		}

	}

	@Override
	public void updateLeaveStatus(Leave leave) {
		try {
			getSimpleJdbcTemplate().update(
					"update employee_leave set status='Approved' where id=?",
					new Object[] { leave.getId() // //CHECK FOR EMPLOYEE!!!
					});
		} catch (DataAccessException e) {
			throw e;
		}

	}

	@Override
	public void denyLeave(int id) {
		try {
			getSimpleJdbcTemplate().update(
					"update employee_leave set status='Denied' where id=?",
					new Object[] { id });
		} catch (DataAccessException e) {
			throw e;
		}

	}

	@Override
	public void deleteLeave(int id) {
		try {
			getSimpleJdbcTemplate().update(
					"delete from employee_leave where id=?",
					new Object[] { id });
		} catch (DataAccessException e) {
			throw e;
		}

	}

	@Override
	public double getLeaveDifference(Date fromDate, Date toDate) {
		double leaveDays = 0.0;
		leaveDays = (toDate.getTime() - fromDate.getTime())
				/ (24 * 60 * 60 * 1000);
		leaveDays = leaveDays + 1;
		return leaveDays;
	}

	/**
	 * @return the employeeService
	 */
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	/**
	 * @param employeeService
	 *            the employeeService to set
	 */
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

}
