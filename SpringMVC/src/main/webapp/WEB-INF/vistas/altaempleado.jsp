<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alta nuevo empleado</title>
</head>
<body>
	<h2>Formulario de Alta de nuevo empleado</h2>
	<form action="/empleado/alta" method="get">
		Nombre: <input type="text" name="nombre" required> <br>
		DNI: <input type="text" name="dni" pattern="(([X-Z]{1})([-]?)(\d{7})([-]?)([A-Z]{1}))|((\d{8})([-]?)([A-Z]{1}))" required><br>
		SEXO: <input type="text" name="sexo" placeholder="M o F" pattern="^[MF]{1}$" required> <br>
		CATEGORIA: <input type="number" name="categoria" min="1" max="10" required> <br>
		ANYOS: <input type="number" name="anyos" min="0" required> <br>	
		<input class="boton" type="submit">
	</form>
	<hr>
	<a href="/">
		<button>Volver al index</button>
	</a>
</body>
</html>