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

var isDecimal  = /^\s*(\+|-)?((\d+(\.\d+)?)|(\.\d+))\s*$/;

function checkRegularExpressionForDecimal(){
	
	var s = $("#level").val();
	var basicSal= $("#basic_salary").val();
	if(String(s).search(isDecimal)!= -1){	
	}else{
		alert('Please enter numeric value for level.');
		return false;
	}
	if(String(basicSal).search(isDecimal)!= -1){	
	}else{
		alert('Please enter numeric value for basic salary.');
		return false;
	}
		
}


</script>
<jsp:include page="../../../WEB-INF/jsp/layout/import_top.jsp"></jsp:include>
<form:form commandName="salary" onsubmit="return checkRegularExpressionForDecimal();">

	<div id="dialog">

			 <table>
                <tr class="prop">
                <td id = "title"><label>Designation * :</label></td>
                <td><form:select path="designation_id">
						<c:forEach items="${desList}" var="des">
							<form:option label="${des.job_title_name}" value="${des.id}" />
						</c:forEach>
					</form:select></td>
                </tr>
                
                <tr class="prop">
                <td id = "title"><label>Level * :</label></td>
                <td id="box"><form:input id="level" path="level" /></td>
                </tr>
                
                <tr class="prop">
                <td id = "title"><label>Basic Salary * :</label></td>
                <td id="box"><form:input id = "basic_salary" path="basic_salary" /></td>
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
