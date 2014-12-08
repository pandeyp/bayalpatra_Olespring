/**
 * 
 */
package com.lbef.serviceimpl;

import java.util.List;

import com.lbef.dao.EmployeeDao;
import com.lbef.dao.UserDao;
import com.lbef.domain.Employee;
import com.lbef.domain.SalaryReport;
import com.lbef.service.EmployeeService;

/**
 * @author Prasanna
 * 
 */
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao employeeDao;
	UserDao userDao;

	@Override
	public void addEmployee(Employee employee) throws Exception {
		employeeDao.addEmployee(employee);
		Employee emp = employeeDao.findEmployee(employee.getUsername());
		employee.setId(emp.getId());
		userDao.addUser(employee);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

	@Override
	public Employee loadEmployee(int id) {
		return employeeDao.loadEmployee(id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
		userDao.deleteUserByEmployeeId(id);
	}
	
	@Override
	public List<SalaryReport> getSalaryReport(){
		return employeeDao.getSalaryReport();
	}

	/**
	 * @return the designationDao
	 */
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	/**
	 * @param designationDao
	 *            the designationDao to set
	 */
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public Employee findEmployee(String userName) {
		return employeeDao.findEmployee(userName);
	}

	@Override
	public List<Employee> getAllTermedEmployee() {
		return employeeDao.getAllTermedEmployee();
	}
	
	@Override
	public String findPassword(int id) {
		return employeeDao.findPassword(id);
	}
}