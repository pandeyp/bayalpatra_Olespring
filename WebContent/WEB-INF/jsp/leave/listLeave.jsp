<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
	import="org.springframework.security.ui.AbstractProcessingFilter"%>
<%@ page
	import="org.springframework.security.ui.webapp.AuthenticationProcessingFilter"%>
<%@ page import="org.springframework.security.AuthenticationException"%>
<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../../../WEB-INF/jsp/layout/import_top.jsp"></jsp:include>

<a href="../leave/addLeave.html"><img src="../resources/img/add.jpg">
	Add Leave</a>

<span id="appLeave"> <a href="../leave/approvedLeaveList.html"><img
		src="../resources/img/process.gif"> Approved Leave List</a> </span>
<br />
<br />


<div class="list">
	<table class="gtable">
		<tr>
			<!-- <th>Id</th> -->
			<th>Employee</th>
			<th>Leave Type</th>
			<th>From Date</th>
			<th>To Date</th>
			<th>Leave Days</th>
			<th>Status</th>
			<th>Action</th>
			<th>Approval Action</th>
		</tr>
		<c:forEach items="${model.leaveList}" var="leave">
			<tr>
				<td><c:forEach items="${model.empList}" var="emp">
						<c:if test="${emp.id==leave.employee_id}">
							<c:out value="${emp.id} - ${emp.first_name}  ${emp.last_name}"></c:out>
						</c:if>
					</c:forEach>
				</td>
				<td><c:out value="${leave.leave_type}"></c:out>
				</td>
				<td><c:out value="${leave.from_date}"></c:out>
				</td>
				<td><c:out value="${leave.to_date}"></c:out>
				</td>
				<td><c:out value="${leave.leave_difference}"></c:out>
				</td>
				<td><c:out value="${leave.status}"></c:out></td>
				<td><a
					href="../leave/editLeave.html?edit=<c:out value="${leave.id}"/>"><img src = "../resources/img/edit_icon.png">  Edit</a>
					/  <a
					href="../leave/deleteLeave.html?delete=<c:out value="${leave.id}"/>" onclick="return confirm('Are you sure you want to delete?');"><img src = "../resources/img/delete.png">  Delete</a>
				<td><a
					href="../leave/approveLeave.html?approve=<c:out value="${leave.id}"/>"><img src = "../resources/img/process.gif">  Approve</a>
					/  <a
					href="../leave/denyLeave.html?deny=<c:out value="${leave.id}"/>" onclick="return confirm('Are you sure you want to deny?');"><img src = "../resources/img/pending-review.jpg">  Deny</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<jsp:include page="../../../WEB-INF/jsp/layout/import_lower.jsp"></jsp:include>