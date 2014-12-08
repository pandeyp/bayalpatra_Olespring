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

import com.lbef.domain.Department;
import com.lbef.service.DepartmentService;

/**
 * @author Prasanna
 *
 */
public class AddDepartmentForm extends SimpleFormController{
	
	DepartmentService departmentService;
	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException e) throws Exception {

		Department department= (Department)command;
		departmentService.addDepartment(department);
        List<Department> departmentList = departmentService.getAllDepartment();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("departmentList", departmentList);
		return new ModelAndView("department/listDepartment", "model", myModel);
    }

}
