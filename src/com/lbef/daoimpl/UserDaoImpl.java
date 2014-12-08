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

import com.lbef.dao.UserDao;
import com.lbef.domain.Employee;
import com.lbef.domain.User;
import com.lbef.service.EmployeeService;

/**
 * @author Prasanna.
 *
 */
public class UserDaoImpl extends SimpleJdbcDaoSupport implements UserDao {
	
	EmployeeService employeeService;
	
	@Override
    public void addUser(Employee employee) throws Exception {
        try {
            String insertUser = "insert into user (username,password,employee_id) values (?,?,?) ";
            getSimpleJdbcTemplate().update(insertUser, new Object[]{employee.getUsername(), employee.getPassword(), employee.getId()});
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
	
	@Override
    public List<User> getAllUser() {
        try {
            List<User> userList = getSimpleJdbcTemplate().query("select * from user", new AllUserMapper());
            return userList;
        } catch (DataAccessException e) {
            throw e;
        }
    }
	
    public class AllUserMapper implements ParameterizedRowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            //.user.setEmployee_id(rs.getString("employee_id"));
            
            Employee employee = employeeService.loadEmployee(rs.getInt("employee_id"));
			user.setEmployee_id(employee);
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
            getSimpleJdbcTemplate().update("update user set username=?, password=? where id=?", new Object[]{user.getUsername(), user.getPassword(), user.getId()});
        } catch (DataAccessException e) {
            throw e;
        }
    }
    
	@Override
	public void deleteUser(int id) {
	     try {
	            getSimpleJdbcTemplate().update("delete from user where id=?", new Object[]{id});
	        } catch (DataAccessException e) {
	            throw e;
	        }
		
	}
	
	@Override
	public void deleteUserByEmployeeId(int id) {
	     try {
	            getSimpleJdbcTemplate().update("delete from user where employee_id=?", new Object[]{id});
	        } catch (DataAccessException e) {
	            throw e;
	        }
	}

	/**
	 * @return the employeeService
	 */
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	/**
	 * @param employeeService the employeeService to set
	 */
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

}
