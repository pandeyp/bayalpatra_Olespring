/**
 * 
 */
package com.lbef.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.lbef.domain.User;
import com.lbef.service.UserService;

/**
 * @author Bhuwan
 *
 */
public class AddUserForm extends SimpleFormController{
	
	UserService userService;
	
	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException e) throws Exception {

        User user = (User)command;
        //userService.addUser(user);
        List<User> userList = userService.getAllUser();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("userList", userList);
		return new ModelAndView("users/usersView", "model", myModel);
    }

}
