<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="servlets.laboral.*" %>
<%@ page import="servlets.gestion.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% BBDD bbdd = new BBDD();
	if(bbdd.salarioempleado(request.getParameter("dni")) > 0) {  %>  
			El salario del empleado es de: <%= bbdd.salarioempleado(request.getParameter("dni")) %> euros
	<% }else{ %> 
			El empleado con ese DNI no existe
	<% } %>
	
	<a href="index.jsp">
		<button>Volver al index</button>
	</a>

</body>
</html>