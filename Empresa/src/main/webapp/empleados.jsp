<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todos los empleados</title>
    <link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
	<table border="1px solid black">
	<tr>
		<th>Nombre</th>
		<th>DNI</th>
		<th>SEXO</th>
		<th>CATEGORIA</th>
		<th>ANYOS</th>
	</tr>	
	<c:forEach items="${lista}" var="empleado">
    	<tr>
        	<td>${empleado.nombre}</td>
			<td>${empleado.dni}</td>
			<td>${empleado.sexo}</td>
			<td>${empleado.categoria}</td>
			<td>${empleado.anyos}</td>
       </tr>
	</c:forEach> 
	</table>
	<a href="index.jsp">
		<button>Volver al index</button>
	</a>
</body>
</html>