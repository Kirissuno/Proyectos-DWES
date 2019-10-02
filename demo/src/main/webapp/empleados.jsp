<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="servlets.laboral.*" %>
<%@ page import="servlets.gestion.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todos los empleados</title>
</head>
<body>
	
	<% BBDD bbdd = new BBDD();
	for(String empleado : bbdd.todoslosempleados()) { %>
		<%= empleado %>
		<br>
	<% } %>
	
	<a href="index.html">
		<button>Volver al index</button>
	</a>
</body>
</html>