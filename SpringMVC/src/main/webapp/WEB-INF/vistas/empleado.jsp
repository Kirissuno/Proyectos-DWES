<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empleados Específico</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body style="background-image: linear-gradient(to right, #9EBDB3, #37B9E9);">
	<div class="container text-center">
		<div class="row justify-content-center">
		<c:choose>
		   <c:when test="${nomina.sueldo > 0}">
		   		<h3>El empleado con DNI : <c:out value="${nomina.dni}"></c:out> tiene un sueldo de <c:out value="${nomina.sueldo}"></c:out>€</h3>
		   </c:when>
		   <c:otherwise>El empleado no existe</c:otherwise>
		</c:choose>
		</div>
	</div>
	<hr>
	<a href="/">
		<button class="btn btn-primary">Volver al index</button>
	</a>
</body>
</html>