/**
 * 
 */
package com.lbef.dao;

import java.util.List;

import com.lbef.domain.Designation;

/**
 * @author Prasanna
 *
 */
public interface DesignationDao {

	void addDesignation(Designation designation) throws Exception;

	List<Designation> getAllDesignation();

	Designation loadDesignation(int id);

	void updateDesignation(Designation designation);

	void deleteDesignation(int id);
}
