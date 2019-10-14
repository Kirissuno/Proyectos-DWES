<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="servlets.gestion.BBDD" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salario</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<c:out value="${respuesta}" />
	
	<a href="index.jsp">
		<button class="boton">Volver al index</button>
	</a>

</body>
</html>