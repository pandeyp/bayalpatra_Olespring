package com.lbef.domain;

public class Leave {

	private Integer id;
	private int employee_id;
	private String leave_type;
	private String from_date; //Make this datefield;
	private String to_date;
	private Double leave_difference;
	private String status;
	private String approved_by;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the employee_id
	 */
	public int getEmployee_id() {
		return employee_id;
	}
	/**
	 * @param employee_id the employee_id to set
	 */
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	/**
	 * @return the leave_type
	 */
	public String getLeave_type() {
		return leave_type;
	}
	/**
	 * @param leave_type the leave_type to set
	 */
	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}
	/**
	 * @return the from_date
	 */
	public String getFrom_date() {
		return from_date;
	}
	/**
	 * @param from_date the from_date to set
	 */
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	/**
	 * @return the to_date
	 */
	public String getTo_date() {
		return to_date;
	}
	/**
	 * @param to_date the to_date to set
	 */
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	/**
	 * @return the leave_difference
	 */
	public Double getLeave_difference() {
		return leave_difference;
	}
	/**
	 * @param leave_difference the leave_difference to set
	 */
	public void setLeave_difference(Double leave_difference) {
		this.leave_difference = leave_difference;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the approved_by
	 */
	public String getApproved_by() {
		return approved_by;
	}
	/**
	 * @param approved_by the approved_by to set
	 */
	public void setApproved_by(String approved_by) {
		this.approved_by = approved_by;
	}


	
}
