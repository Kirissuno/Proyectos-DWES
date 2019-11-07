<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
</head>
<body style="background-image: linear-gradient(to right, #9EBDB3, #37B9E9);">

	<div class="container text-center">
	<h2>Nominas!</h2>
	<div class="row justify-content-center">
		<form action="/empleados" method="get">
			<input class="btn btn-primary" type="submit" value="Ver todos los empleados">
		</form>
	</div>
	<div class="row justify-content-center">
		<form action="/nomina" method="get">
			Ver salario del empleado con DNI: <input type="text" id="dni" name="dni" required>
			<input class="btn btn-primary" type="submit" >
		</form>
	</div>
	<div class="row justify-content-center">	
		<form action="/empleado" method="get">
			Modificar el empleado con DNI: <input type="text" id="dni" name="dni" required>
			<input class="btn btn-primary" type="submit">
		</form>
	</div>
	<div class="row justify-content-center">
		<form action="/alta" method="get">
			<input class="btn btn-primary" type="submit" value="Dar de alta nuevo empleado">
		</form>
	</div>
	</div>
</body>
</html>