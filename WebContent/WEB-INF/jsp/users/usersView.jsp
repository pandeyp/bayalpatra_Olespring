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
<script type="text/javascript">
function checkValues(){
	if(document.getElementById("level").value == ''){
		alert('Please enter a level.');
		document.getElementById("level").focus();
		return false;
	}
	else if(document.getElementById("basic_salary").value == ''){
		alert('Please enter basic salary.');
		document.getElementById("basic_salary").focus();
		return false;
	}
	return true;
}
</script>

<jsp:include page="../../../WEB-INF/jsp/layout/import_top.jsp"></jsp:include>


<div class="list">
<br/>
<br/>
	<table class="gtable">

			<tr>
				<th>Id</th>
				<th>Username</th>
				<th>Employee</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${model.userList}" var="us">
				<tr>
					<td><c:out value="${us.id}"></c:out></td>
					<td><c:out value="${us.username}"></c:out></td>
					<td><c:out value="${us.employee_id.id} - ${us.employee_id.first_name} ${us.employee_id.last_name}"></c:out></td>
					<td><a
						href="../users/editUser.html?edit=<c:out value="${us.id}"/>"><img src = "../resources/img/edit_icon.png">  Edit</a>
						/  <a
						href="../users/deleteUsers.html?delete=<c:out value="${us.id}"/>" onclick="return confirm('Are you sure you want to delete?');"><img src = "../resources/img/delete.png">
							Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		</div>
		<jsp:include page="../../../WEB-INF/jsp/layout/import_lower.jsp"></jsp:include>