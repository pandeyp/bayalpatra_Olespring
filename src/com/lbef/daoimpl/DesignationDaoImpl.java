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

import com.lbef.dao.DesignationDao;
import com.lbef.domain.Designation;


/**
 * @author Prasanna
 *
 */
public class DesignationDaoImpl extends SimpleJdbcDaoSupport implements DesignationDao {
	
	@Override
    public void addDesignation(Designation designation) throws Exception {
        try {
            String insertDesignation = "insert into designation (job_title_name,job_description) values (?,?) ";
            getSimpleJdbcTemplate().update(insertDesignation, new Object[]{designation.getJob_title_name(), designation.getJob_description()});
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
/*	
	@Override
    public List<User> getAllUser() {
        try {
            List<User> userList = getSimpleJdbcTemplate().query("select * from user", new AllUserMapper());
            return userList;
        } catch (DataAccessException e) {
            throw e;
        }
    }
	
    private static class AllUserMapper implements ParameterizedRowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmployee_id(rs.getString("employee_id"));
            return user;
        }
    }
    
    @Override
    public User loadUser(int id) {
        try {
            User user = getSimpleJdbcTemplate().queryForObject("select * from user where id=?", new AllUserMapper(), id);
            return user;
        } catch (DataAccessException e) {
            throw e;
        }
    }
    
    @Override
    public void updateUser(User user) {
        try {
            getSimpleJdbcTemplate().update("update user set username=?, password=?, employee_id=? where id=?", new Object[]{user.getUsername(), user.getPassword(), user.getEmployee_id(), user.getId()});
        } catch (DataAccessException e) {
            throw e;
        }
    }
*/

	@Override
	public List<Designation> getAllDesignation() {
		try {
            List<Designation> designationList = getSimpleJdbcTemplate().query("select * from designation", new AllDesignationMapper());
            return designationList;
        } catch (DataAccessException e) {
            throw e;
        }

	}
	
	private static class AllDesignationMapper implements ParameterizedRowMapper<Designation> {
        public Designation mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Designation designation = new Designation();
            designation.setId(rs.getInt("id"));
            designation.setJob_title_name(rs.getString("job_title_name"));
            designation.setJob_description(rs.getString("job_description"));
            return designation;
        }
    }

	@Override
	public Designation loadDesignation(int id) {
        try {
            Designation designation = getSimpleJdbcTemplate().queryForObject("select * from designation where id=?", new AllDesignationMapper(), id);
            return designation;
        } catch (DataAccessException e) {
            throw e;
        }
    }

	@Override
	public void updateDesignation(Designation designation) {
	     try {
	            getSimpleJdbcTemplate().update("update designation set job_title_name=?, job_description=? where id=?", new Object[]{designation.getJob_title_name(), designation.getJob_description(), designation.getId()});
	        } catch (DataAccessException e) {
	            throw e;
	        }
		
	}
	
	@Override
	public void deleteDesignation(int id) {
	     try {
	            getSimpleJdbcTemplate().update("delete from designation where id=?", new Object[]{id});
	        } catch (DataAccessException e) {
	            throw e;
	        }
		
	}


}
