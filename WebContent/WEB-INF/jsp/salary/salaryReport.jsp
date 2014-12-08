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

<!-- <a href="../salary/addSalary.html"><img src = "../resources/img/add.jpg">   Add Basic Salary</a> -->
<br />
<br />


<div class="list">
	<table class="gtable">
		<tr>
			<!-- <th>Id</th> -->
			<th>First Name</th>
			<th>Last Name</th>
			<th>Designation</th>
			<th>Basic Salary</th>
			<th>Salary Month</th>
		</tr>
		<c:forEach items="${model.salaryList}" var="sal">
			<tr>
			
				<td><c:out value="${sal.first_name}"></c:out></td>
				<td><c:out value="${sal.last_name}"></c:out></td>
				<td><c:out value="${sal.designation}"></c:out></td>
				<td><c:out value="${sal.basic_salary}"></c:out></td>
				<td>
				<c:if test="${sal.salary_month=='1'}">Jan - 2012</c:if></td>
	<%-- 			<td><a
					href="../salary/editSalary.html?edit=<c:out value="${sal.id}"/>"><img src = "../resources/img/edit_icon.png"> Edit</a>
					/  <a
					href="../salary/deleteSalary.html?delete=<c:out value="${sal.id}"/>"><img src = "../resources/img/delete.png">  Delete</a></td>
			</tr> --%>
		</c:forEach>
	</table>
</div>
<jsp:include page="../../../WEB-INF/jsp/layout/import_lower.jsp"></jsp:include>