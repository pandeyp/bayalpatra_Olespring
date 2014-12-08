/**
 * 
 */
package com.lbef.service;

import java.util.List;

import com.lbef.domain.Employee;
import com.lbef.domain.User;

/**
 * @author Bhuwan
 *
 */
public interface UserService {

	List<User> getAllUser();

	User loadUser(int id);

	void updateUser(User user);

	void deleteUser(int id);

	void addUser(Employee employee) throws Exception;
}
