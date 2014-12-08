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

<a href="../department/addDepartment.html"><img src = "../resources/img/add.jpg">   Add Department</a>

<br/>
<br/>


	<div class="list"><table class="gtable">
		<tr>
			<th>Company</th>
			<th>Name</th>
			<th>Level</th>
			<th>Description</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${model.departmentList}" var="dept">
			<tr>
				<td><c:out value="${dept.company_id}"></c:out>
				</td>
				<td><c:out value="${dept.name}"></c:out>
				</td>
				<td><c:out value="${dept.level}"></c:out>
				</td>
				<td><c:out value="${dept.description}"></c:out>
				</td>
				<td><a href="../department/editDepartment.html?edit=<c:out value="${dept.id}"/>"><img src = "../resources/img/edit_icon.png">  Edit</a>
				/  <a href="../department/deleteDepartment.html?delete=<c:out value="${dept.id}"/>" onclick="return confirm('Are you sure you want to delete?');"><img src = "../resources/img/delete.png">  Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table></div>
<jsp:include page="../../../WEB-INF/jsp/layout/import_lower.jsp"></jsp:include>