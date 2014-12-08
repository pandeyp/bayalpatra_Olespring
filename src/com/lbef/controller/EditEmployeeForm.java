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
import com.lbef.domain.Designation;
import com.lbef.domain.Employee;
import com.lbef.service.DepartmentService;
import com.lbef.service.DesignationService;
import com.lbef.service.EmployeeService;

/**
 * @author Bhuwan
 * 
 */
public class EditEmployeeForm extends SimpleFormController {

	EmployeeService employeeService;
	DepartmentService departmentService;
	DesignationService designationService;

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	protected Map referenceData(HttpServletRequest request) throws Exception {
		List<Department> deptList = departmentService.getAllDepartment();
		List<Designation> desList = designationService.getAllDesignation();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("deptList", deptList);
		myModel.put("desList", desList);
		return myModel;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		String id = request.getParameter("edit");
		Employee employee = null;
		if (id != null) {
			employee = employeeService.loadEmployee(Integer.valueOf(id));
			employee.setPassword(employeeService.findPassword(employee.getId()));
		}
		return employee;
	}

	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException e)
			throws Exception {
		System.out.println("Inside updateEmployee method");
		Employee employee = (Employee) command;
		employeeService.updateEmployee(employee);
		List<Employee> employeeList = employeeService.getAllEmployee();
		List<Department> deptList = departmentService.getAllDepartment();
		List<Designation> desList = designationService.getAllDesignation();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("deptList", deptList);
		myModel.put("desList", desList);
		myModel.put("employeeList", employeeList);
		return new ModelAndView("employee/listEmployee", "model", myModel);

	}

	/**
	 * @return the departmentService
	 */
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	/**
	 * @param departmentService
	 *            the departmentService to set
	 */
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	/**
	 * @return the designationService
	 */
	public DesignationService getDesignationService() {
		return designationService;
	}

	/**
	 * @param designationService
	 *            the designationService to set
	 */
	public void setDesignationService(DesignationService designationService) {
		this.designationService = designationService;
	}

}
