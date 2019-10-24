<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h2>Nominas!</h2>

	<form action="UnicoServlet" method="post">
		<input type="hidden" name="accion" value="consultarempleados">
		<input class="boton" type="submit" name="empleados" value="Ver todos los empelados">
	</form>
	<br>
	<form action="UnicoServlet" method="post">
		<input type="hidden" name="accion" value="consultarsalario">
		Ver salario del empleado <input type="text" name="dni">
		<input class="boton" type="submit" >
	</form>
	
	<br>
	<form action="UnicoServlet" method="post">
		<input type="hidden" name="accion" value="infoempleado">
		Modificar el empleado con DNI: <input type="text" name="dni">
		<input class="boton" type="submit">
	</form>

</body>
</html>
