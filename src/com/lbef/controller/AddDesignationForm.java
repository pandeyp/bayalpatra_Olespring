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

import com.lbef.domain.Designation;
import com.lbef.service.DesignationService;

/**
 * @author Prasanna
 *
 */
public class AddDesignationForm extends SimpleFormController{
	
	DesignationService designationService;
	
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

	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException e) throws Exception {

		Designation designation= (Designation)command;
        designationService.addDesignation(designation);
        List<Designation> designationList = designationService.getAllDesignation();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("designationList", designationList);
		return new ModelAndView("designation/listDesignation", "model", myModel);
    }

}
