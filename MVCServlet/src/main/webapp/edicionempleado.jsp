<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edicion</title>
    <link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
	<form action="UnicoServlet" method="post">
		<input type="hidden" name="accion" value="modificarenbd">
		Nombre: <input type="text" name="nombre" value="${empleado.nombre}"> <br>
		DNI: <input type="text" name="dni" value="${empleado.dni}" readonly> <br>
		SEXO: <input type="text" name="sexo" value="${empleado.sexo}" placeholder="M o F" pattern="^[MF]{1}$"> <br>
		CATEGORIA: <input type="number" name="categoria" value="${empleado.categoria}" min="1" max="10"> <br>
		ANYOS: <input type="number" name="anyos" value="${empleado.anyos}" min="0"> <br>	
		<input class="boton" type="submit" value="Enviar">
	</form>


	<br>
	<a href="index.jsp">
		<button class="boton">Volver al index</button>
	</a>
</body>
</html>