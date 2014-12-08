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

import com.lbef.dao.SalaryDao;
import com.lbef.domain.Salary;
import com.lbef.service.DesignationService;

/**
 * @author Prasanna
 * 
 */
public class SalaryDaoImpl extends SimpleJdbcDaoSupport implements
		SalaryDao {
	
	DesignationService designationService;
	
	public void addSalary(Salary salary) throws Exception {
        try {
            String insertSalary = "insert into salary (level,basic_salary,designation_id) values (?,?,?) ";
            getSimpleJdbcTemplate().update(insertSalary, new Object[]{salary.getLevel(),salary.getBasic_salary(),salary.getDesignation_id()});
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

	public List<Salary> getAllSalary() {
		try {
            List<Salary> salaryList = getSimpleJdbcTemplate().query("select * from salary", new AllSalaryMapper());
            return salaryList;
        } catch (DataAccessException e) {
            throw e;
        }

	}
	
	public class AllSalaryMapper implements ParameterizedRowMapper<Salary> {
        public Salary mapRow(ResultSet rs, int rowNum) throws SQLException {
        	
        	Salary salary = new Salary();
        	salary.setId(rs.getInt("id"));
        	salary.setLevel(rs.getString("level"));
        	salary.setBasic_salary(rs.getInt("basic_salary"));
        	
			salary.setDesignation_id(rs.getInt("designation_id"));
        	
        	return salary;
        }
    }

	@Override
	public Salary loadSalary(int id) {
        try {
            Salary salary = getSimpleJdbcTemplate().queryForObject("select * from salary where id=?", new AllSalaryMapper(), id);
            return salary;
        } catch (DataAccessException e) {
            throw e;
        }
    }

	@Override
	public void updateSalary(Salary salary) {
	     try {
	            getSimpleJdbcTemplate().update("update salary set level=?, basic_salary=?, designation_id=? where id=?", new Object[]{
	            		salary.getLevel(),
	            		salary.getBasic_salary(),
	            		salary.getDesignation_id(),
	            		salary.getId()}); ////Check!!!
	        } catch (DataAccessException e) {
	            throw e;
	        }
		
	}
	
	@Override
	public void deleteSalary(int id) {
	     try {
	            getSimpleJdbcTemplate().update("delete from salary where id=?", new Object[]{id});
	        } catch (DataAccessException e) {
	            throw e;
	        }
	        
		
	}

	/**
	 * @return the designationService
	 */
	public DesignationService getDesignationService() {
		return designationService;
	}

	/**
	 * @param designationService the designationService to set
	 */
	public void setDesignationService(DesignationService designationService) {
		this.designationService = designationService;
	}


}
