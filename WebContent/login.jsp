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

	if (request.getParameter("logout") != null
			&& request.getParameter("logout").equals("logout")) {
		session.removeAttribute("username");
	}
%>
<script type="text/javascript">
$(document).ready(function() {
//	$("#catchfocus").focus();
	document.getElementById("catch").focus();
	 });

</script>
<jsp:include page="WEB-INF/jsp/layout/import_top1.jsp"></jsp:include>


<c:if test="${not empty model.message}">
	<p class="validation_login">
		<c:out value="${model.message}" />
	</p>
</c:if>
<div class="right_box">

	<form name="f" action="<c:url value='j_spring_security_check'/>"
		method="post">


		<div class="login_info">
			<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login to Bayalpatra</h2>
			<ul>
				<li><span>Username:</span><input id="catch" type='text'
					name='j_username'
					value='<c:if
test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>' />
				</li>
				<li><span>Password:</span><input type='password'
					name='j_password'></li>
				<li><span>&nbsp;</span><input type='submit' name="submit"
					value="Submit"></input></li>
			</ul>
			<div style="clear: both;"></div>
		</div>
	</form>

</div>

<div style="clear: both;"></div>
<div class="clearall"></div>

<jsp:include page="WEB-INF/jsp/layout/import_lower.jsp"></jsp:include>


<%-- <div id="mainwrapper">
<div id="header">
<div id="welmsg"></div>


<div class="clearboth"></div>
<div id="bodywrapper">

<div id="login_container_new"><c:if
	test="${not empty model.message}">
	<p class="validation_login"><c:out value="${model.message}" /></p>
</c:if>
<div class="right_box">



<form name="f" action="<c:url value='j_spring_security_check'/>" method="post">


<div class="login_info">
<h2>Login to HRM</h2>
<ul>
	<li><span>Username:</span><input type='text' name='j_username'
		value='<c:if
test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>' /></li>
	<li><span>Password:</span><input type='password' name='j_password'></li>
	<li><span>&nbsp;</span><input type='submit' name="submit"
		value="Submit"></input></li>
</ul>
<div style="clear: both;"></div>
</div>
</form>

</div>
<div style="clear: both;"></div>
<div class="clearall"></div>
<div id="footer"></div>
</div>

</div> 
	</body>
	</html>--%>