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

<a href="../salary/addSalary.html"><img src = "../resources/img/add.jpg">   Add Basic Salary</a>
<br />
<br />


<div class="list">
	<table class="gtable">
		<tr>
			<!-- <th>Id</th> -->
			<th>Designation</th>
			<th>Level</th>
			<th>Basic Salary</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${model.salaryList}" var="sal">
			<tr>
				<td><c:forEach items="${model.desList}" var="des">
						<c:if test="${des.id==sal.designation_id}">
							<c:out value="${des.job_title_name}"></c:out>
						</c:if>
					</c:forEach>
				</td>
				<td><c:out value="${sal.level}"></c:out></td>
				<td><c:out value="${sal.basic_salary}"></c:out></td>
				<td><a
					href="../salary/editSalary.html?edit=<c:out value="${sal.id}"/>"><img src = "../resources/img/edit_icon.png"> Edit</a>
					/  <a
					href="../salary/deleteSalary.html?delete=<c:out value="${sal.id}"/>" onclick="return confirm('Are you sure you want to delete?');"><img src = "../resources/img/delete.png">  Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
<jsp:include page="../../../WEB-INF/jsp/layout/import_lower.jsp"></jsp:include>