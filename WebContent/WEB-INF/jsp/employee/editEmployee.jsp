<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	if(document.getElementById("first_name").value == ''){
		alert('Please enter first name.');
		document.getElementById("first_name").focus();
		return false;
	}
	else if(document.getElementById("last_name").value == ''){
		alert('Please enter last name.');
		document.getElementById("last_name").focus();
		return false;
	}
	else if(document.getElementById("marital_status").value == ''){
		alert('Please select a marital status.');
		document.getElementById("marital_status").focus();
		return false;
	}
	else if(document.getElementById("date_of_birth").value == ''){
		alert('Please enter date of birth.');
		document.getElementById("date_of_birth").focus();
		return false;
	}
	else if(document.getElementById("join_date").value == ''){
		alert('Please enter join_date.');
		document.getElementById("join_date").focus();
		return false;
	}
	else if(document.getElementById("status").value == ''){
		alert('Please enter status.');
		document.getElementById("status").focus();
		return false;
	}
	else if(document.getElementById("username").value == ''){
		alert('Please enter username.');
		document.getElementById("username").focus();
		return false;
	}
	else if(document.getElementById("password").value == ''){
		alert('Please enter password.');
		document.getElementById("password").focus();
		return false;
	}
	else if(document.getElementById("email").value == ''){   //email validation!!!
		alert('Please enter email.');
		document.getElementById("email").focus();
		return false;
	}
	else if(document.getElementById("permanent_address").value == ''){
		alert('Please enter permanent address.');
		document.getElementById("permanent_adress").focus();
		return false;
	}
	
	return true;
}

function checkRegularExpressionForEmail(){
	var e = $("#email").val();          
	email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;           
	if(!email_regex.test(e)){
		alert('Please enter a valid email address.');
		return false;
	}else{
		
		return true;
	}
}

</script>
<jsp:include page="../../../WEB-INF/jsp/layout/import_top.jsp"></jsp:include>
<form:form commandName="employee" onsubmit="return checkRegularExpressionForEmail();">

	<div id="dialog">

		<table>
			<tr class="prop">
				<td id="title"><label>First Name * :</label></td>
				<td><form:input id="first_name" path="first_name" /></td>
				<td id="title"><label>Middle Name :</label></td>
				<td><form:input path="middle_name" /></td>
			</tr>

			<tr class="prop">
				<td id="title"><label>Last Name * :</label></td>
				<td><form:input id="last_name"  path="last_name" /></td>
				<td id="title"><label>Marital Status * :</label></td>		
				<td><form:select id="marital_status" path="marital_status">
				 		<option value="">Select...</option>
						<option value="Single" <c:if test="${employee.marital_status=='Single'}"> selected="selected"</c:if>
							>Single</option>
						<option value="Married" <c:if test="${employee.marital_status=='Married'}"> selected="selected"</c:if> 
						>Married</option>
						<option value="Divorced" <c:if test="${employee.marital_status=='Divorced'}"> selected="selected"</c:if>
						>Divorced</option>
						<option value="Widowed" <c:if test="${employee.marital_status=='Widowed'}"> selected="selected"</c:if> 
						>Widowed</option>
					</form:select>
				</td>
			</tr>

			<tr class="prop">
				<td id="title"><label>Date Of Birth * :</label></td>
				<td><form:input id="date_of_birth" path="date_of_birth" /><i>  (YYYY-MM-DD)</i></td>
				<td><label>Gender * :</label></td>
				<td><input type="radio" name="gender" value="Male" <c:if test="${employee.gender=='Male'}"> checked="checked"</c:if>
				>Male
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"
					name="gender" value="Female" <c:if test="${employee.gender=='Female'}"> checked="checked"</c:if>
					>Female</td>
			</tr>

			<tr>

			</tr>

			<tr class="prop">
				<td id="title"><label>Join Date * :</label></td>
				<td><form:input id="join_date" path="join_date" /><i>  (YYYY-MM-DD)</i></td>
				<td>
					<%-- <fmt:formatDate pattern="dd/MM/yyyy" value="${pago.fecha}" var="auxvarfechatoprint"/> --%>
			</tr>
			<tr class="prop">
				<td id="title"><label>Department * :</label>
				</td>
				<td><form:select path="department_id">
						<c:forEach items="${deptList}" var="dept">
							<form:option label="${dept.name}" value="${dept.id}" />
						</c:forEach>
					</form:select></td>
				<td id="title"><label>Designation * :</label>
				</td>
				<td><form:select path="designation_id">
						<c:forEach items="${desList}" var="des">
							<form:option label="${des.job_title_name}" value="${des.id}" />
						</c:forEach>
					</form:select></td>
			</tr>

			<tr class="prop">
				<td id="title"><label>Status * :</label></td>
				<td><form:select path="status" id ="status">
						<option value="">Select...</option>
						<option value="Permanent" <c:if test="${employee.status=='Permanent'}"> selected="selected"</c:if>
						>Permanent</option>
						<option value="Temporary" <c:if test="${employee.status=='Temporary'}"> selected="selected"</c:if>
						>Temporary</option>
						<option value="Volunteer" <c:if test="${employee.status=='Volunteer'}"> selected="selected"</c:if>
						>Volunteer</option>
						<option value="Terminated" <c:if test="${employee.status=='Terminated'}"> selected="selected"</c:if>
						>Terminated</option>
					</form:select>
				</td>
			</tr>

			<tr class="prop">
				<td id="title"><label>Username * :</label></td>
				<td><form:input id="username" path="username" /></td>
				<td id="title"><label>Password * :</label></td>
				<td><form:password id="password" showPassword="true" path="password" /></td>
			</tr>

			<tr class="prop">
				<td id="title"><label>Email * :</label></td>
				<td><form:input id="email" path="email" /></td>
			</tr>


			<tr class="prop">
				<td id="title"><label>Permanent Address * :</label></td>
				<td><form:input id="permanent_address" path="permanent_address" /></td>
				<td id="title"><label>Temporary Address :</label></td>
				<td><form:input path="temporary_address" /></td>
			</tr>

			<tr class="prop">
				<td id="title"><label>Home Phone :</label></td>
				<td><form:input path="home_phone" /></td>
				<td id="title"><label>Mobile Number :</label></td>
				<td><form:input path="mobile" /></td>
			</tr>
		</table>
		<div id="formbuttons">
		<input type="submit" value="Update" class="savebutton" onclick="return checkValues();" />
		</div>
	</div>
</form:form>
<jsp:include page="../../../WEB-INF/jsp/layout/import_lower.jsp"></jsp:include>