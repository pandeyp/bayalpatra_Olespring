package com.lbef.service;

import java.util.List;

import com.lbef.domain.Department;

/**
 * @author Prasanna
 *
 */
public interface DepartmentService {

	void addDepartment(Department department) throws Exception;

	List<Department> getAllDepartment();

	Department loadDepartment(int id);

	void updateDepartment(Department department);

	void deleteDepartment(int id);
}

