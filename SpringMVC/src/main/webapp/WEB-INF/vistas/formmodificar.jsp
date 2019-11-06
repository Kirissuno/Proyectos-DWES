<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empleado a modificar</title>
</head>
<body>
	<h2>Formulario de modificación</h2>
	<form action="/empleado/mod" method="get">
		Nombre: <input type="text" name="nombre" value="${empleado.nombre}"> <br>
		DNI: <input type="text" name="dni" value="${empleado.dni}" readonly> <br>
		SEXO: <input type="text" name="sexo" value="${empleado.sexo}" placeholder="M o F" pattern="^[MF]{1}$"> <br>
		CATEGORIA: <input type="number" name="categoria" value="${empleado.categoria}" min="1" max="10"> <br>
		ANYOS: <input type="number" name="anyos" value="${empleado.anyos}" min="0"> <br>	
		<input class="boton" type="submit">
	</form>
	<hr>
	<a href="/">
		<button>Volver al index</button>
	</a>
</body>
</html>