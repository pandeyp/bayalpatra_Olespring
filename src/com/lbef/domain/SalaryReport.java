package com.lbef.domain;

public class SalaryReport {

	private String first_name;
	private String last_name;
	private String designation;
	private Double basic_salary;
	private String salary_month;

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name
	 *            the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name
	 *            the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation
	 *            the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the salary_month
	 */
	public String getSalary_month() {
		return salary_month;
	}

	/**
	 * @param salary_month
	 *            the salary_month to set
	 */
	public void setSalary_month(String salary_month) {
		this.salary_month = salary_month;
	}

	/**
	 * @return the basic_salary
	 */
	public Double getBasic_salary() {
		return basic_salary;
	}

	/**
	 * @param basic_salary
	 *            the basic_salary to set
	 */
	public void setBasic_salary(Double basic_salary) {
		this.basic_salary = basic_salary;
	}

}
