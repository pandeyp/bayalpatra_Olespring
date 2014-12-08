/**
 * 
 */
package com.lbef.serviceimpl;

import java.util.Date;
import java.util.List;

import com.lbef.dao.LeaveDao;
import com.lbef.domain.Leave;
import com.lbef.service.LeaveService;

/**
 * @author Prasanna
 *
 */
public class LeaveServiceImpl implements LeaveService {

	LeaveDao leaveDao;

	@Override
	public void addLeave(Leave leave) throws Exception{
		leaveDao.addLeave(leave);
	}
	
	@Override
	public List<Leave> getAllUnapprovedLeave() {
		return leaveDao.getAllUnapprovedLeave();
	}
	
	@Override
    public Leave loadLeave(int id) {
		return leaveDao.loadLeave(id);
	}
	
	@Override
    public void updateLeave(Leave leave) {
		leaveDao.updateLeave(leave);
	}
	
	@Override
	public void deleteLeave(int id) {
		leaveDao.deleteLeave(id);
	}
	
	@Override
	public double getLeaveDifference(Date fromDate, Date toDate){
		return leaveDao.getLeaveDifference(fromDate, toDate);
	}
	
	@Override
	public List<Leave> getAllApprovedLeave() {
		return leaveDao.getAllApprovedLeave();
	}
	
	@Override
	public void updateLeaveStatus(Leave leave) {
		leaveDao.updateLeaveStatus(leave);
	}
	
	@Override
	public void denyLeave(int id) {
		leaveDao.denyLeave(id);
		
	}

	/**
	 * @return the leaveDao
	 */
	public LeaveDao getLeaveDao() {
		return leaveDao;
	}

	/**
	 * @param leaveDao the leaveDao to set
	 */
	public void setLeaveDao(LeaveDao leaveDao) {
		this.leaveDao = leaveDao;
	}

	

	
}