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

<a href="../designation/addDesignation.html"><img src = "../resources/img/add.jpg">   Add Designation</a>

<br/>
<br/>


	<div class="list"><table class="gtable">
		<tr>
			<th>Id</th>
			<th>Job Title Name</th>
			<th>Job Description</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${model.designationList}" var="desig">
			<tr>
				<td><c:out value="${desig.id}"></c:out>
				</td>
				<td><c:out value="${desig.job_title_name}"></c:out>
				</td>
				<td><c:out value="${desig.job_description}"></c:out>
				</td>
				<td><a href="../designation/editDesignation.html?edit=<c:out value="${desig.id}"/>"> <img src = "../resources/img/edit_icon.png">  Edit</a>
				/  <a href="../designation/deleteDesignation.html?delete=<c:out value="${desig.id}"/>" onclick="return confirm('Are you sure you want to delete?');"><img src = "../resources/img/delete.png">   Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table></div>
<jsp:include page="../../../WEB-INF/jsp/layout/import_lower.jsp"></jsp:include>