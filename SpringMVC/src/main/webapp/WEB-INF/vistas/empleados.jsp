<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todos los empleados</title>
</head>
<body>
	<table border="1px solid black">
	<tr>
		<th>Nombre</th>
		<th>DNI</th>
		<th>SEXO</th>
		<th>CATEGORIA</th>
		<th>ANYOS</th>
		<th>Accion</th>
	</tr>	
	<c:forEach items="${lista}" var="empleado">
    	<tr>
        	<td>${empleado.nombre}</td>
			<td>${empleado.dni}</td>
			<td>${empleado.sexo}</td>
			<td>${empleado.categoria}</td>
			<td>${empleado.anyos}</td>
			<td>
				<form action="/empleados/borrar">
					<input type="hidden" value="${empleado.dni}" name="dni">
					<input value="Borrar" class="boton" type="submit" />
				</form>
			</td>
       </tr>
	</c:forEach> 
	</table>
	<hr>
	<a href="/">
		<button>Volver al index</button>
	</a>
</body>
</html>