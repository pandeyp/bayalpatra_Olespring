/**
 * 
 */
package com.lbef.dao;

import java.util.Date;
import java.util.List;

import com.lbef.domain.Leave;

/**
 * @author Prasanna
 *
 */
public interface LeaveDao {

	void addLeave(Leave leave) throws Exception;

	List<Leave> getAllUnapprovedLeave();

	Leave loadLeave(int id);

	void updateLeave(Leave leave);

	void deleteLeave(int id);

	double getLeaveDifference(Date fromDate, Date toDate);

	List<Leave> getAllApprovedLeave();

	void updateLeaveStatus(Leave leave);

	void denyLeave(int id);
}
