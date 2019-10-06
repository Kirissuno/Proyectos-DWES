<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP</title>
</head>
<body>
<h2>Hello World!</h2>

	<a href="empleados.jsp"><button>Ver todos los empleados</button></a>
	<br>
	<form action="salarioespecifico.jsp" method="post">
		Ver salario del empleado <input type="text" id="dni" name="dni"></input>
		<input type="submit" >
	</form>
	
	<br>
	<button>Submenu de edicion</button>
	<br>
	<button>Recalcular y actualizar sueldo de un empleado</button>
	<br>
	<button>Recalcular y actualizar sueldos de todos los empleados</button>
	<br>
	<button>Realizar copia de seguridad de la BBDD en fichero</button>
	<br>
	<button>Alta de nuevos empleados</button>
	<br>
	<button>Dar de baja empleado</button>
	<br>
	<button>Cargar backup.txt a la base de datos</button>
	<br>
	<button>Guardar todos los salarios junto al empleado</button>
	<br>


</body>
</html>
