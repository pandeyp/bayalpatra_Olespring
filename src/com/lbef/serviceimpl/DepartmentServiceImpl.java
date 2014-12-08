/**
 * 
 */
package com.lbef.serviceimpl;

import java.util.List;

import com.lbef.dao.DepartmentDao;
import com.lbef.domain.Department;
import com.lbef.service.DepartmentService;

/**
 * @author Prasanna
 *
 */
public class DepartmentServiceImpl implements DepartmentService {

	DepartmentDao departmentDao;

	@Override
	public void addDepartment(Department department) throws Exception{
		departmentDao.addDepartment(department);
	}
	
	@Override
	public List<Department> getAllDepartment() {
		return departmentDao.getAllDepartment();
	}
	
	@Override
    public Department loadDepartment(int id) {
		return departmentDao.loadDepartment(id);
	}
	
	@Override
    public void updateDepartment(Department department) {
		departmentDao.updateDepartment(department);
	}
	
	@Override
	public void deleteDepartment(int id) {
		departmentDao.deleteDepartment(id);
	}


	
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	
}