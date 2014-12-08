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
<jsp:include page="../../../WEB-INF/jsp/layout/import_top.jsp"></jsp:include>
        <form:form commandName="user">

            <ul class="mainform">
                <li><label>ID:</label><form:input path="id"/></li>
                <li><label>User name:</label><form:input path="username" /></li>
                <li><label>Password:</label><form:password path="password" /></li>
                <li><label>Employee Id:</label><form:input path="employee_id" /></li>
                <li><label></label><input type="submit" />
            </ul>
        </form:form>
<jsp:include page="../../../WEB-INF/jsp/layout/import_lower.jsp"></jsp:include>
