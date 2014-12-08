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
import com.lbef.domain.Salary;
import com.lbef.service.DesignationService;
import com.lbef.service.SalaryService;

public class SalaryController extends MultiActionController implements
		InitializingBean {

	SalaryService salaryService;
	DesignationService designationService;
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	public ModelAndView listSalary(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException {
		System.out.println("Inside listSalary method");
		List<Salary> salaryList = salaryService.getAllSalary();
		List<Designation> desList = designationService.getAllDesignation();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("desList", desList);
		myModel.put("salaryList", salaryList);
		return new ModelAndView("salary/listSalary", "model", myModel);
	}

	public ModelAndView deleteSalary(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException {
		System.out.println("Inside deleteSalary method");
		String id = request.getParameter("delete");
		if (id != null) {
			salaryService.deleteSalary(Integer.valueOf(id));
		}
		List<Salary> salaryList = salaryService.getAllSalary();
		List<Designation> desList = designationService.getAllDesignation();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("salaryList", salaryList);
		myModel.put("desList", desList);
		return new ModelAndView("salary/listSalary", "model", myModel);
	}

	public void afterPropertiesSet() {
	}

	/**
	 * @return the salaryService
	 */
	public SalaryService getSalaryService() {
		return salaryService;
	}

	/**
	 * @param salaryService
	 *            the salaryService to set
	 */
	public void setSalaryService(SalaryService salaryService) {
		this.salaryService = salaryService;
	}

	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return LOGGER;
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
