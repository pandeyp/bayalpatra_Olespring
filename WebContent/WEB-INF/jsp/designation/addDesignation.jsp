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
	if(document.getElementById("job_title").value == ''){
		alert('Please insert a job title.');
		document.getElementById("job_title").focus();
		return false;
	}
	return true;
}

</script>
<jsp:include page="../../../WEB-INF/jsp/layout/import_top.jsp"></jsp:include>
<form:form commandName="designation">

	<div id="dialog">

		<table>
			<tr class="prop">
				<td id="title"><label>Job Title Name:</label></td>
				<td><form:input id="job_title" path="job_title_name" /></td>
			</tr>

			<tr class="prop">
				<td id="title"><label>Job Description:</label></td>
				<td id="box"><form:input path="job_description" /></td>
			</tr>
		</table>
		<br />
		<div id="formbuttons">
			<input type="submit" value="Save" class="savebutton"
				onclick="return checkValues();" />
		</div>
	</div>
</form:form>

<jsp:include page="../../../WEB-INF/jsp/layout/import_lower.jsp"></jsp:include>
