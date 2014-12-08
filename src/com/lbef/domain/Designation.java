/**
 * 
 */
package com.lbef.domain;
/**
 * @author Prasanna
 *
 */
public class Designation {
	
	private Integer id;
	private String job_title_name;
	private String job_description;
	
	
	
	
	public String getJob_title_name() {
		return job_title_name;
	}
	public void setJob_title_name(String job_title_name) {
		this.job_title_name = job_title_name;
	}
	public String getJob_description() {
		return job_description;
	}
	public void setJob_description(String job_description) {
		this.job_description = job_description;
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
	
}
