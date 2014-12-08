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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../../../WEB-INF/jsp/layout/import_top.jsp"></jsp:include>




<div id="homeleftbox">
<br>
<p align="center">Welcome to Bayalpatra </p>
<p align="center">HR Management System for Bayalpatra Hospital.</p>
</div>
<div id="homerightbox">
	<img src="../resources/img/bayalpata_hospital.jpg">
</div>



<jsp:include page="../../../WEB-INF/jsp/layout/import_lower.jsp"></jsp:include>