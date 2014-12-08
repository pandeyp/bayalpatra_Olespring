/**
 * 
 */
package com.lbef.serviceimpl;

import java.util.List;

import com.lbef.dao.SalaryDao;
import com.lbef.domain.Salary;
import com.lbef.service.SalaryService;

/**
 * @author Prasanna
 *
 */
public class SalaryServiceImpl implements SalaryService {

	SalaryDao salaryDao;

	@Override
	public void addSalary(Salary salary) throws Exception{
		salaryDao.addSalary(salary);
	}
	
	@Override
	public List<Salary> getAllSalary() {
		return salaryDao.getAllSalary();
	}
	
	@Override
    public Salary loadSalary(int id) {
		return salaryDao.loadSalary(id);
	}
	
	@Override
    public void updateSalary(Salary salary) {
		salaryDao.updateSalary(salary);
	}
	
	@Override
	public void deleteSalary(int id) {
		salaryDao.deleteSalary(id);
	}

	/**
	 * @return the salaryDao
	 */
	public SalaryDao getSalaryDao() {
		return salaryDao;
	}

	/**
	 * @param salaryDao the salaryDao to set
	 */
	public void setSalaryDao(SalaryDao salaryDao) {
		this.salaryDao = salaryDao;
	}
	
}