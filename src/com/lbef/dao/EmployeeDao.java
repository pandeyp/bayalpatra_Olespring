/**
 * 
 */
package com.lbef.dao;

import java.util.List;

import com.lbef.domain.Employee;
import com.lbef.domain.SalaryReport;

/**
 * @author Prasanna
 *
 */
public interface EmployeeDao {

	void addEmployee(Employee employee) throws Exception;

	List<Employee> getAllEmployee();

	Employee loadEmployee(int id);

	void updateEmployee(Employee employee);

	void deleteEmployee(int id);

	Employee findEmployee(String userName);

	List<Employee> getAllTermedEmployee();

	String findPassword(int id);

	List<SalaryReport> getSalaryReport();
}
