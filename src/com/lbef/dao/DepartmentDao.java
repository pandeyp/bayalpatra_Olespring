/**
 * 
 */
package com.lbef.dao;

import java.util.List;

import com.lbef.domain.Department;;

/**
 * @author Prasanna
 *
 */
public interface DepartmentDao {

	void addDepartment(Department department) throws Exception;

	List<Department> getAllDepartment();

	Department loadDepartment(int id);

	void updateDepartment(Department Department);

	void deleteDepartment(int id);
}
