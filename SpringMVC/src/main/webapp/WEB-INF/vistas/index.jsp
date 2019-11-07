<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h2>Nominas!</h2>

	<form action="/empleados" method="get">
		<input class="boton" type="submit" value="Ver todos los empleados">
	</form>
	<br>
	<form action="/nomina" method="get">
		Ver salario del empleado <input type="text" id="dni" name="dni" required>
		<input class="boton" type="submit" >
	</form>
	
	<br>
	<form action="/empleado" method="get">
		Modificar el empleado con DNI: <input type="text" id="dni" name="dni" required>
		<input class="boton" type="submit">
	</form>
	<br>
	<form action="/alta" method="get">
		<input class="boton" type="submit" value="Dar de alta nuevo empleado">
	</form>

</body>
</html>