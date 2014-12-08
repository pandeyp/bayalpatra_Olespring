/**
 * 
 */
package com.lbef.serviceimpl;

import java.util.List;

import com.lbef.dao.DesignationDao;
import com.lbef.domain.Designation;
import com.lbef.service.DesignationService;

/**
 * @author Prasanna
 *
 */
public class DesignationServiceImpl implements DesignationService {
	DesignationDao designationDao;
	
	@Override
	public void addDesignation(Designation designation) throws Exception{
		designationDao.addDesignation(designation);
	}
	
	@Override
	public List<Designation> getAllDesignation() {
		return designationDao.getAllDesignation();
	}
	
	@Override
    public Designation loadDesignation(int id) {
		return designationDao.loadDesignation(id);
	}
	
	@Override
    public void updateDesignation(Designation designation) {
		designationDao.updateDesignation(designation);
	}
	
	@Override
	public void deleteDesignation(int id) {
		designationDao.deleteDesignation(id);
	}

	/**
	 * @return the designationDao
	 */
	public DesignationDao getDesignationDao() {
		return designationDao;
	}

	/**
	 * @param designationDao the designationDao to set
	 */
	public void setDesignationDao(DesignationDao designationDao) {
		this.designationDao = designationDao;
	}

}
