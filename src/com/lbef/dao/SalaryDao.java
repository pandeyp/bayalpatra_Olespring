/**
 * 
 */
package com.lbef.dao;

import java.util.List;

import com.lbef.domain.Salary;

/**
 * @author Prasanna
 *
 */
public interface SalaryDao {

	void addSalary(Salary salary) throws Exception;

	List<Salary> getAllSalary();

	Salary loadSalary(int id);

	void updateSalary(Salary salary);

	void deleteSalary(int id);
}
