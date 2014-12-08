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

import com.lbef.domain.Employee;
import com.lbef.domain.Leave;
import com.lbef.service.EmployeeService;
import com.lbef.service.LeaveService;

public class LeaveController extends MultiActionController implements
		InitializingBean {

	LeaveService leaveService;
	EmployeeService employeeService;
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	public ModelAndView listLeave(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException {
		System.out.println("Inside listLeave method");
		List<Leave> leaveList = leaveService.getAllUnapprovedLeave();
		List<Employee> empList = employeeService.getAllEmployee();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("leaveList", leaveList);
		myModel.put("empList",empList);
		return new ModelAndView("leave/listLeave", "model", myModel);
	}
	
	public ModelAndView approveLeaveList(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException {
		System.out.println("Inside approveLeaveList method");
		List<Leave> leaveList = leaveService.getAllApprovedLeave();
		List<Employee> empList = employeeService.getAllEmployee();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("leaveList", leaveList);
		myModel.put("empList",empList);
		return new ModelAndView("leave/approvedLeaveList", "model", myModel);
	}

	public ModelAndView deleteLeave(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException {
		System.out.println("Inside deleteLeave method");
		String id = request.getParameter("delete");
		if (id != null) {
			leaveService.deleteLeave(Integer.valueOf(id));
		}
		List<Leave> leaveList = leaveService.getAllUnapprovedLeave();
		List<Employee> empList = employeeService.getAllEmployee();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("leaveList", leaveList);
		myModel.put("empList",empList);
		return new ModelAndView("leave/listLeave", "model", myModel);
	}
	
	public ModelAndView updateLeaveStatus(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException {
		System.out.println("Inside updateLeave method");
		String id = request.getParameter("approve");
		if (id != null) {
			leaveService.updateLeaveStatus(leaveService.loadLeave(Integer.valueOf(id)));
		}
		List<Leave> leaveList = leaveService.getAllUnapprovedLeave();
		List<Employee> empList = employeeService.getAllEmployee();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("leaveList", leaveList);
		myModel.put("empList", empList);
		return new ModelAndView("leave/listLeave", "model", myModel);
	}

	
	public ModelAndView denyLeave(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException {
		System.out.println("Inside denyLeave method");
		String id = request.getParameter("deny");
		if (id != null) {
			/*leaveService.denyLeave(leaveService.loadLeave(Integer.valueOf(id)));*/
			leaveService.denyLeave(Integer.valueOf(id));
			
		}
		List<Leave> leaveList = leaveService.getAllUnapprovedLeave();
		List<Employee> empList = employeeService.getAllEmployee();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("leaveList", leaveList);
		myModel.put("empList", empList);
		return new ModelAndView("leave/listLeave", "model", myModel);
	}

	
	public void afterPropertiesSet() {
	}

	/**
	 * @return the leaveService
	 */
	public LeaveService getLeaveService() {
		return leaveService;
	}

	/**
	 * @param leaveService
	 *            the leaveService to set
	 */
	public void setLeaveService(LeaveService leaveService) {
		this.leaveService = leaveService;
	}

	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return LOGGER;
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
