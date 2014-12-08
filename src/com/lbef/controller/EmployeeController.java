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
import com.lbef.domain.Designation;
import com.lbef.domain.Employee;
import com.lbef.domain.Leave;
import com.lbef.domain.SalaryReport;
import com.lbef.service.DepartmentService;
import com.lbef.service.DesignationService;
import com.lbef.service.EmployeeService;

public class EmployeeController extends MultiActionController implements
		InitializingBean {

	EmployeeService employeeService;
	DepartmentService departmentService;
	DesignationService designationService;

	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	protected Map referenceData(HttpServletRequest request) throws Exception {
		List<Department> deptList = departmentService.getAllDepartment();
		List<Designation> desList = designationService.getAllDesignation();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("deptList", deptList);
		myModel.put("desList", desList);
		return myModel;
	}
	
	public ModelAndView listEmployee(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException {
		System.out.println("Inside listEmployee method");
		List<Employee> employeeList = employeeService.getAllEmployee();
		List<Department> deptList = departmentService.getAllDepartment();
		List<Designation> desList = designationService.getAllDesignation();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("deptList", deptList);
		myModel.put("desList", desList);
		myModel.put("employeeList", employeeList);
		return new ModelAndView("employee/listEmployee", "model", myModel);
	}
	
	public ModelAndView deleteEmployee(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException {
		System.out.println("Inside deleteEmployee method");
		String id = request.getParameter("delete"); 
		if (id != null) { 
			employeeService.deleteEmployee(Integer.valueOf(id));
		}
		List<Employee> employeeList = employeeService.getAllEmployee();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("employeeList", employeeList);
		return new ModelAndView("employee/listEmployee", "model", myModel);
	}
	
	public ModelAndView termedEmployee(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException {
		System.out.println("Inside termedEmployeeList method");
		List<Employee> empList = employeeService.getAllTermedEmployee();
		List<Department> deptList = departmentService.getAllDepartment();
		List<Designation> desList = designationService.getAllDesignation();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("empList",empList);
		myModel.put("deptList", deptList);
		myModel.put("desList", desList);
		return new ModelAndView("employee/terminatedEmployeeList", "model", myModel);
	}
	
	public ModelAndView salaryReport(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException {
		System.out.println("Inside termedEmployeeList method");
		List<SalaryReport> salaryList = employeeService.getSalaryReport();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("salaryList",salaryList);
		return new ModelAndView("salary/salaryReport", "model", myModel);
	}
	
	public void afterPropertiesSet() {
	}
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/**
	 * @return the departmentService
	 */
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	/**
	 * @param departmentService the departmentService to set
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
	 * @param designationService the designationService to set
	 */
	public void setDesignationService(DesignationService designationService) {
		this.designationService = designationService;
	}


}
