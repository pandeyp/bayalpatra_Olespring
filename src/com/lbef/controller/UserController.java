package com.lbef.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.lbef.domain.User;
import com.lbef.service.UserService;

public class UserController extends MultiActionController implements
		InitializingBean {

	UserService userService;
	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	public ModelAndView homeHandler(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {

		HttpSession session = request.getSession();
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication a = sc.getAuthentication();
		
		session.setAttribute("username", a.getName());
		System.out.println("username: " + a.getName());

		/*
		 * if (user.getFirstname() == null && user.getLastname() == null) {
		 * session.setAttribute("myusername", getUsername());
		 * session.setAttribute("fullname", ""); } else {
		 * session.setAttribute("myusername", "");
		 * session.setAttribute("fullname", user.getFirstname() + " " +
		 * user.getLastname()); session.setAttribute("firstname",
		 * user.getFirstname()); }
		 */

		Map<String, Object> myModel = new HashMap<String, Object>();
		System.out.println("Inside homeHandler method");
		return new ModelAndView("users/home", "model", myModel);

	}

	public ModelAndView editUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside editUser method");
		String id = request.getParameter("edit");
		User user = null;
		if (id != null) {
			user = userService.loadUser(Integer.valueOf(id));
		}

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("user", user);
		return new ModelAndView("users/updateUser", myModel);
	}
	
	
	public ModelAndView updateUser(HttpServletRequest request,
			HttpServletResponse response, Object command) throws ServletException {
		System.out.println("Inside updateUser method");
		User user = (User)command;
		userService.updateUser(user);
		List<User> userList = userService.getAllUser();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("userList", userList);
		return new ModelAndView("users/usersView", "model", myModel);
	}
	
	public ModelAndView usersView(HttpServletRequest request,
			HttpServletResponse response, Object command) throws ServletException {
		System.out.println("Inside usersView method");
		List<User> userList = userService.getAllUser();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("userList", userList);
		return new ModelAndView("users/usersView", "model", myModel);
	}
	
	public ModelAndView deleteUsers(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException {
		System.out.println("Inside deleteUser method");
		String id = request.getParameter("delete"); 
		if (id != null) { 
			userService.deleteUser(Integer.valueOf(id));
		}
		List<User> userList = userService.getAllUser();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("userList", userList);
		return new ModelAndView("users/usersView", "model", myModel);
	}

	public void afterPropertiesSet() {
	}

	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService
	 *            the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
