/**
 * 
 */
package com.lbef.serviceimpl;

import java.util.List;

import com.lbef.dao.UserDao;
import com.lbef.domain.Employee;
import com.lbef.domain.User;
import com.lbef.service.UserService;

/**
 * @author Bhuwan
 *
 */
public class UserServiceImpl implements UserService {
	UserDao userDao;
	
	@Override
	public void addUser(Employee employee) throws Exception{
		userDao.addUser(employee);
	}
	
	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}
	
	@Override
    public User loadUser(int id) {
		return userDao.loadUser(id);
	}
	
	@Override
    public void updateUser(User user) {
		userDao.updateUser(user);
	}
	
	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
