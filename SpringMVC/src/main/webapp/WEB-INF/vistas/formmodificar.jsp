<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empleado a modificar</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body style="background-image: linear-gradient(to right, #9EBDB3, #37B9E9);">
	<div class="container text-center">
		<h2>Formulario de modificación</h2>
		<div class="row justify-content-center">
			<form:form action="/empleado/mod" method="POST" modelAttribute="empleado">
				<form:label path="nombre">Nombre: </form:label> <form:input required="required" type="text" path="nombre" /><br>
				<form:label path="dni">DNI: </form:label> <form:input readonly="true"  type="text" path="dni"/><br>
				<form:label path="sexo">Sexo: </form:label> <form:input required="required" type="text" path="sexo" placeholder="M o F" pattern="^[MF]{1}$"/><br>
				<form:label path="categoria">Categoria: </form:label> <form:input required="required"  type="number" path="categoria" min="1" max="10"/><br>
				<form:label path="anyos">Anyos: </form:label> <form:input required="required" type="number" path="anyos" min="0"/><br>
				
				<input type="submit" class="btn btn-primary" value="Modificar">
			</form:form>
		</div>
	</div>
	<hr>
	<a href="/">
		<button class="btn btn-primary">Volver al index</button>
	</a>
</body>
</html>