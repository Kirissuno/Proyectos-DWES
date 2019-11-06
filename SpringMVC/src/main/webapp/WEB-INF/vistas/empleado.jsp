<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empleados Específico</title>
</head>
<body>
	<c:choose>
	   <c:when test="${nomina.sueldo > 0}">
	   		<h3>El empleado con DNI : <c:out value="${nomina.dni}"></c:out> tiene un sueldo de <c:out value="${nomina.sueldo}"></c:out>€</h3>
	   </c:when>
	   <c:otherwise>El empleado no existe</c:otherwise>
	</c:choose>

	<hr>
	<a href="/">
		<button>Volver al index</button>
	</a>
</body>
</html>