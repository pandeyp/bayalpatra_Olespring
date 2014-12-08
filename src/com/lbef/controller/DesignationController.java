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

import com.lbef.domain.Designation;
import com.lbef.service.DesignationService;

public class DesignationController extends MultiActionController implements
		InitializingBean {

	DesignationService designationService;
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

	public ModelAndView listDesignation(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException {
		System.out.println("Inside updateUser method");
		List<Designation> designationList = designationService.getAllDesignation();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("designationList", designationList);
		return new ModelAndView("designation/listDesignation", "model", myModel);
	}
	
	public ModelAndView deleteDesignation(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException {
		System.out.println("Inside deleteDesignation method");
		String id = request.getParameter("delete"); 
		if (id != null) { 
			designationService.deleteDesignation(Integer.valueOf(id));
		}
		List<Designation> designationList = designationService.getAllDesignation();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("designationList", designationList);
		return new ModelAndView("designation/listDesignation", "model", myModel);
	}
	
/*	public ModelAndView updateDesignation(HttpServletRequest request,
			HttpServletResponse response, Object command) throws ServletException {
		System.out.println("Inside updateDesignation method");
		Designation designation = (Designation)command;
		designationService.updateDesignation(designation);
		List<Designation> designationList = designationService.getAllDesignation();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("designationList", designationList);
		return new ModelAndView("designation/listDesignation", "model", myModel);
		
	}*/

	public void afterPropertiesSet() {
	}

	/**
	 * @return the userService
	 */
	public DesignationService getDesignationService() {
		return designationService;
	}

	/**
	 * @param userService
	 *            the userService to set
	 */
	public void setDesignationService(DesignationService designationService) {
		this.designationService = designationService;
	}

}
