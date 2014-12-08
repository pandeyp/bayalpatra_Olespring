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
	if(document.getElementById("name").value == ''){
		alert('Please insert a name for department.');
		document.getElementById("name").focus();
		return false;
	}
 	else if(document.getElementById("level").value == ''){
		alert('Please insert a level.');
		document.getElementById("level").focus();
		return false; 
	}
	return true;
}

var isDecimal  = /^\s*(\+|-)?((\d+(\.\d+)?)|(\.\d+))\s*$/;

function checkRegularExpressionForLevel(){
	
	var s = $("#level").val();
	if(String(s).search(isDecimal)!= -1){
		
	}else{
		alert('Please enter numeric value for level.');
		return false;
	}
	
}

</script>
<jsp:include page="../../../WEB-INF/jsp/layout/import_top.jsp"></jsp:include>
<form:form commandName="department" onsubmit="return checkRegularExpressionForLevel();">

	<div id="dialog">

			 <table>
                <tr class="prop">
                <td id = "title"><label>Company:</label></td>
                <td><form:input path="company_id" /></td>  <!-- add drop down for company -->
                </tr>
                
                <tr class="prop">
                <td id = "title"><label>Name:</label></td>
                <td id="box"><form:input id ="name" path="name" /></td>
                </tr>
                
                <tr class="prop">
                <td id = "title"><label>Level:</label></td>
                <td id="box">
                <form:input id="level" path="level" />
                </td>
                </tr>
                
                <tr class="prop">
                <td id = "title"><label>Description:</label></td>
                <td id="box"><form:input path="description" /></td>
                </tr>

				</table>
				<br/>
				<div id="formbuttons">
				<input type="submit" value="Save" class="savebutton" onclick="return checkValues();"/>
				</div>
</div>
        </form:form>
<jsp:include page="../../../WEB-INF/jsp/layout/import_lower.jsp"></jsp:include>
