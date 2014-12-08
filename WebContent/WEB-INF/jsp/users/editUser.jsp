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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<script type="text/javascript">
function checkValues(){
	if(document.getElementById("username").value == ''){
		alert('Please insert a username.');
		document.getElementById("username").focus();
		return false;
	}
	else if(document.getElementById("password").value == ''){
		alert('Please insert a password.');
		document.getElementById("password").focus();
		return false;
	}
	return true;
}
</script>
<jsp:include page="../../../WEB-INF/jsp/layout/import_top.jsp"></jsp:include>
<form:form commandName="user">

	<div id="dialog">

			 <table>
                <tr class="prop">
                <td id = "title"><label>Username:</label></td>
                <td><form:input id ="username" path="username" /></td> 
                </tr>
                
                <tr class="prop">
                <td id = "title"><label>Password:</label></td>
                <td id="box"><form:password id = "password" showPassword="true" path="password" /></td>
                </tr>
				</table>
				<br/>
				<div id="formbuttons">
				<input type="submit" value="Update" class="savebutton" onclick="return checkValues();"/>
				</div>
</div>
        </form:form>
        
        <jsp:include page="../../../WEB-INF/jsp/layout/import_lower.jsp"></jsp:include>