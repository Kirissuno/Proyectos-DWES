<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edicion</title>
    <link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
		<% Boolean resolucion = (Boolean) request.getAttribute("resolucion"); 
		if(resolucion != null){ 
			if( resolucion == true ) { %>
				<h3 style="color:green"> Modificado correctamente </h3>
		<% }else{ %>
				<h3 style="color:red"> No se ha modificado nada </h3>
		<% } }%>		
		
		<a href="index.jsp">
			<button class="boton">Volver al index</button>
		</a>

</body>
</html>