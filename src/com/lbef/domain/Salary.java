package com.lbef.domain;

public class Salary {

	private Integer id;
	private String level;
	private Integer basic_salary;
	private int designation_id;
	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * @return the designation_id
	 */

	/**
	 * @return the basic_salary
	 */
	public Integer getBasic_salary() {
		return basic_salary;
	}
	/**
	 * @param basic_salary the basic_salary to set
	 */
	public void setBasic_salary(Integer basic_salary) {
		this.basic_salary = basic_salary;
	}
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
	 * @return the designation_id
	 */
	public int getDesignation_id() {
		return designation_id;
	}
	/**
	 * @param designation_id the designation_id to set
	 */
	public void setDesignation_id(int designation_id) {
		this.designation_id = designation_id;
	}

}
