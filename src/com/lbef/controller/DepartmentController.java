package com.lbef.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.lbef.domain.Department;
import com.lbef.service.DepartmentService;

public class DepartmentController extends MultiActionController implements
		InitializingBean {

	DepartmentService departmentService;
	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	/*
	 * public ModelAndView homeHandler(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException {
	 * 
	 * HttpSession session = request.getSession(); //
	 * session.setAttribute("username", getUsername());
	 * 
	 * 
	 * if (user.getFirstname() == null && user.getLastname() == null) {
	 * session.setAttribute("myusername", getUsername());
	 * session.setAttribute("fullname", ""); } else {
	 * session.setAttribute("myusername", ""); session.setAttribute("fullname",
	 * user.getFirstname() + " " + user.getLastname());
	 * session.setAttribute("firstname", user.getFirstname()); }
	 * 
	 * 
	 * Map<String, Object> myModel = new HashMap<String, Object>();
	 * System.out.println("Inside homeHandler method"); return new
	 * ModelAndView("users/home", "model", myModel);
	 * 
	 * }
	 * 
	 * public ModelAndView editUser(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException {
	 * System.out.println("Inside editUser method"); String id =
	 * request.getParameter("edit"); User user = null; if (id != null) { user =
	 * userService.loadUser(Integer.valueOf(id)); }
	 * 
	 * Map<String, Object> myModel = new HashMap<String, Object>();
	 * myModel.put("user", user); return new ModelAndView("users/editUser",
	 * myModel); }
	 */

	public ModelAndView listDepartment(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException {
		System.out.println("Inside listDepartment method");
		List<Department> departmentList = departmentService.getAllDepartment();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("departmentList", departmentList);
		return new ModelAndView("department/listDepartment", "model", myModel);
	}
	
	public ModelAndView deleteDepartment(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException {
		System.out.println("Inside deleteDepartment method");
		String id = request.getParameter("delete"); 
		if (id != null) { 
			departmentService.deleteDepartment(Integer.valueOf(id));
		}
		List<Department> departmentList =departmentService.getAllDepartment();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("departmentList", departmentList);
		return new ModelAndView("department/listDepartment", "model", myModel);
	}
	
/*	public ModelAndView updateDesignation(HttpServletRequest request,
			HttpServletResponse response, Object command) throws ServletException {
		System.out.println("Inside updateDesignation method");
		Department department = (Department)command;
		departmentService.updateDesignation(department);
		List<Department> designationList = departmentService.getAllDesignation();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("designationList", designationList);
		return new ModelAndView("department/listDesignation", "model", myModel);
		
	}*/

	public void afterPropertiesSet() {
	}

	/**
	 * @return the userService
	 */
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	/**
	 * @param userService
	 *            the userService to set
	 */
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

}
