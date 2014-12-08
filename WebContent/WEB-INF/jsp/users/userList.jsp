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

<br>

	<table border="1">
		<tr>
			<!-- <th>Id</th> -->
			<th>Username</th>
			<th>Employee ID:</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${model.userList}" var="user">
			<tr>
				<td><c:out value="${user.username}"></c:out>
				</td>
				<td><c:out value="${user.employee_id}"></c:out>
				</td>
				<td><a href="../users/editUser.html?edit=<c:out value="${user.id}"/>">Edit</a>
				/<a href="../users/deleteUsers.html?delete=<c:out value="${user.id}"/>"> Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<jsp:include page="../../../WEB-INF/jsp/layout/import_lower.jsp"></jsp:include>