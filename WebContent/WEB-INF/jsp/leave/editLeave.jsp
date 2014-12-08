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
	if(document.getElementById("leave_type").value == ''){
		alert('Please insert type of leave.');
		document.getElementById("leave_type").focus();
		return false;
	}
	return true;
}

</script>
<jsp:include page="../../../WEB-INF/jsp/layout/import_top.jsp"></jsp:include>
<form:form commandName="leave">

	<div id="dialog">

			 <table>
                <tr class="prop">
                <td id = "title"><label>Employee:</label></td>
        		  <td><form:select path="employee_id">
						<c:forEach items="${empList}" var="emp">
							<form:option label="${emp.id} - ${emp.first_name}  ${emp.last_name}" value="${emp.id}" />
						</c:forEach>
					</form:select></td>
         
                </tr>
                
                <tr class="prop">
                <td id = "title"><label>Leave Type:</label></td>
                <td id="box"><form:input id ="leave_type" path="leave_type" /></td>
                </tr>
                
                  <tr class="prop">
                <td id = "title"><label>From Date:</label></td>
                <td id="box"><form:input path="from_date" /><i>   (YYYY-MM-DD)</i></td>    <!-- Use date picker DDL -->
                </tr>
                
                     <tr class="prop">
                <td id = "title"><label>To Date:</label></td>
                <td id="box"><form:input path="to_date" /><i>   (YYYY-MM-DD)</i></td>
                </tr>

				</table>
										<br/>
				<div id="formbuttons">
				<input type="submit" value="Update" class="savebutton" onclick = "return checkValues();"/>
				</div>
</div>
        </form:form>
        
<jsp:include page="../../../WEB-INF/jsp/layout/import_lower.jsp"></jsp:include>
