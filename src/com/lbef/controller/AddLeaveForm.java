/**
 * 
 */
package com.lbef.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.lbef.domain.Employee;
import com.lbef.domain.Leave;
import com.lbef.service.EmployeeService;
import com.lbef.service.LeaveService;


/**
 * @author Prasanna
 *
 */
public class AddLeaveForm extends SimpleFormController{
	
	LeaveService leaveService;
	EmployeeService employeeService;
	
	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		List<Employee> empList = employeeService.getAllEmployee();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("empList", empList);
		return myModel;
	}

	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException e) throws Exception {

		Leave leave= (Leave)command;
		leave.setLeave_difference(leaveService.getLeaveDifference(Date.valueOf(leave.getFrom_date()), Date.valueOf(leave.getTo_date())));
		leave.setStatus("Unapproved");
        leaveService.addLeave(leave);
        List<Leave> leaveList = leaveService.getAllUnapprovedLeave();
        List<Employee> empList = employeeService.getAllEmployee();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("leaveList", leaveList);
		myModel.put("empList",empList);
		return new ModelAndView("leave/listLeave", "model", myModel);
    }

	/**
	 * @return the leaveService
	 */
	public LeaveService getLeaveService() {
		return leaveService;
	}

	/**
	 * @param leaveService the leaveService to set
	 */
	public void setLeaveService(LeaveService leaveService) {
		this.leaveService = leaveService;
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
