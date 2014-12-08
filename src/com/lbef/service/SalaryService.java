package com.lbef.service;

import java.util.List;

import com.lbef.domain.Salary;

/**
 * @author Prasanna
 *
 */
public interface SalaryService {

	void addSalary(Salary salary) throws Exception;

	List<Salary> getAllSalary();

	Salary loadSalary(int id);

	void updateSalary(Salary salary);

	void deleteSalary(int id);
}
