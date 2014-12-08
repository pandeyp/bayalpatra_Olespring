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

import com.lbef.dao.DepartmentDao;
import com.lbef.domain.Department;


/**
 * @author Prasanna
 *
 */
public class DepartmentDaoImpl extends SimpleJdbcDaoSupport implements DepartmentDao {
	
	@Override
    public void addDepartment(Department department) throws Exception {
        try {
            String insertDepartment = "insert into department (company_id,name,level,description) values (?,?,?,?) ";
            getSimpleJdbcTemplate().update(insertDepartment, new Object[]{department.getCompany_id(),department.getName(), department.getLevel(),department.getDescription()});
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

	public List<Department> getAllDepartment() {
		try {
            List<Department> departmentList = getSimpleJdbcTemplate().query("select * from department", new AllDepartmentMapper());
            return departmentList;
        } catch (DataAccessException e) {
            throw e;
        }

	}
	
	private static class AllDepartmentMapper implements ParameterizedRowMapper<Department> {
        public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Department department = new Department();
        	department.setId(rs.getInt("id"));
            department.setCompany_id(rs.getString("company_id"));
            department.setName(rs.getString("name"));
            department.setLevel(rs.getString("level"));
        	department.setDescription(rs.getString("description"));
        	return department;
        }
    }

	@Override
	public Department loadDepartment(int id) {
        try {
            Department department = getSimpleJdbcTemplate().queryForObject("select * from department where id=?", new AllDepartmentMapper(), id);
            return department;
        } catch (DataAccessException e) {
            throw e;
        }
    }

	@Override
	public void updateDepartment(Department department) {
	     try {
	            getSimpleJdbcTemplate().update("update department set company_id=?, name=?, level=?, description=? where id=?", new Object[]{department.getCompany_id(),department.getName(), department.getLevel(),department.getDescription(),department.getId()});
	        } catch (DataAccessException e) {
	            throw e;
	        }
		
	}
	
	@Override
	public void deleteDepartment(int id) {
	     try {
	            getSimpleJdbcTemplate().update("delete from department where id=?", new Object[]{id});
	        } catch (DataAccessException e) {
	            throw e;
	        }
	        
		
	}


}
