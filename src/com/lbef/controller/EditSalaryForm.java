package com.lbef.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.lbef.domain.Designation;
import com.lbef.domain.Salary;
import com.lbef.service.DesignationService;
import com.lbef.service.SalaryService;

/**
 * @author Prasanna
 * 
 */
public class EditSalaryForm extends SimpleFormController {

	SalaryService salaryService;
	DesignationService designationService;
	
	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		List<Designation> desList = designationService.getAllDesignation();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("desList", desList);
		return myModel;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		String id = request.getParameter("edit");
		Salary salary = null;
		if (id != null) {
			salary=salaryService.loadSalary(Integer.valueOf(id)); 
		}
		return salary;
	}

	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException e)
			throws Exception {
		System.out.println("Inside updateSalary method");
		Salary salary = (Salary)command;
		salaryService.updateSalary(salary);
		List<Salary> salaryList = salaryService.getAllSalary();
		List<Designation> desList = designationService.getAllDesignation();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("salaryList", salaryList);
		myModel.put("desList", desList);
		return new ModelAndView("salary/listSalary", "model", myModel);

	}

	/**
	 * @return the salaryService
	 */
	public SalaryService getSalaryService() {
		return salaryService;
	}

	/**
	 * @param salaryService the salaryService to set
	 */
	public void setSalaryService(SalaryService salaryService) {
		this.salaryService = salaryService;
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
