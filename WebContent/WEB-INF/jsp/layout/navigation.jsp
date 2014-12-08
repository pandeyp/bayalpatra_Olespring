<div id="Header">
	<div class="leftHeader"></div>
	<div class="rightHeader">
		<%
			String username = (String) session.getAttribute("username");
			if (username == null) {
				response.sendRedirect("login.jsp");
			}
		%>

	<b>	WELCOME :</b><b><%out.println(username);%></b> | <a href="../login.jsp?logout='logout'">Logout</a>
	</div>
	<div class="clear"></div>
</div>