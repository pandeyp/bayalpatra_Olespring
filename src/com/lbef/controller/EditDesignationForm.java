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
import com.lbef.service.DesignationService;

/**
 * @author Bhuwan
 * 
 */
public class EditDesignationForm extends SimpleFormController {

	DesignationService designationService;

	public DesignationService getDesignationService() {
		return designationService;
	}

	public void setDesignationService(DesignationService designationService) {
		this.designationService = designationService;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		String id = request.getParameter("edit");
		Designation designation = null;
		if (id != null) {
			designation= designationService.loadDesignation(Integer.valueOf(id));
		}
		return designation;
	}

	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException e)
			throws Exception {
		System.out.println("Inside updateDesignation method");
		Designation designation = (Designation)command;
		designationService.updateDesignation(designation);
		List<Designation> designationList = designationService.getAllDesignation();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("designationList", designationList);
		return new ModelAndView("designation/listDesignation", "model", myModel);

	}

}
