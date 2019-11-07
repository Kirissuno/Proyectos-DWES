<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alta nuevo empleado</title>
</head>
<body>
	<h2>Formulario de Alta de nuevo empleado</h2>

	<form:form action="/empleado/alta" method="POST" modelAttribute="empleado">
		<form:label path="nombre">Nombre: </form:label> <form:input required="required" type="text" path="nombre" /><br>
		<form:label path="dni">Dni: </form:label> <form:input required="required" type="text" path="dni" pattern="(([X-Z]{1})([-]?)(\d{7})([-]?)([A-Z]{1}))|((\d{8})([-]?)([A-Z]{1}))"/><br>
		<form:label path="sexo">Sexo: </form:label> <form:input required="required" type="text" path="sexo" placeholder="M o F" pattern="^[MF]{1}$"/><br>
		<form:label path="categoria">Categoria: </form:label> <form:input required="required" type="number" path="categoria" min="1" max="10"/><br>
		<form:label path="anyos">Anyos: </form:label> <form:input required="required" type="number" path="anyos" min="0"/><br>
		
		<input type="submit" value="Dar de Alta">
	</form:form>
	
	
	<hr>
	<a href="/">
		<button>Volver al index</button>
	</a>
</body>
</html>