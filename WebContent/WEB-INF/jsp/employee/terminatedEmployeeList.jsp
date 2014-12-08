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

<!-- <a href="../employee/addEmployee.html"><img src = "../resources/img/add.jpg">   Add Employee</a> -->
<br />
<br />


<div class="list">
	<table class="gtable">
		<tr>
			<!-- <th>Id</th> -->
			<th>First Name</th>
			<th>Last Name</th>
			<th>Designation</th>
			<th>Department</th>
			<th>Join Date</th>
			<th>Status</th>
		<!-- 	<th>Mobile</th> -->
			<th>Gender</th>
			<th>Date Of Birth</th>
			<th>Email</th>

		</tr>
		<c:forEach items="${model.empList}" var="emp">
			<tr>
				<td><c:out value="${emp.first_name}"></c:out></td>
				<td><c:out value="${emp.last_name}"></c:out></td>
				<td><c:forEach items="${model.desList}" var="des">
						<c:if test="${des.id==emp.designation_id}">
							<c:out value="${des.job_title_name}"></c:out>
						</c:if>
					</c:forEach></td>
				<td><c:forEach items="${model.deptList}" var="dept">
						<c:if test="${dept.id==emp.department_id}">
							<c:out value="${dept.name}"></c:out>
						</c:if>
					</c:forEach>
				</td>
				<td><c:out value="${emp.join_date}"></c:out></td>
				<td><c:out value="${emp.status}"></c:out></td>
			<%-- 	<td><c:out value="${emp.mobile}"></c:out></td> --%>
				<td><c:out value="${emp.gender}"></c:out></td>
				<td><c:out value="${emp.date_of_birth}"></c:out></td>
				<td><c:out value="${emp.email}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</div>
<jsp:include page="../../../WEB-INF/jsp/layout/import_lower.jsp"></jsp:include>