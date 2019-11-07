<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todos los empleados</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body style="background-image: linear-gradient(to right, #9EBDB3, #37B9E9);">
	<div class="container text-center">
	<h1>Todos los empleados</h1>
		<div class="row justify-content-center">
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
							<input class="btn btn-primary" value="Borrar" class="boton" type="submit" />
						</form>
					</td>
		       </tr>
			</c:forEach> 
			</table>
		</div>
	</div>
	<hr>
	<a href="/">
		<button class="btn btn-primary">Volver al index</button>
	</a>
</body>
</html>