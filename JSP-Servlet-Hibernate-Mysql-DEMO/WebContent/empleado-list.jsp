<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>User Management Application</title>
</head>
<body>
	<h1>User Management</h1>
       <h2>
       	<a href="new">Add New User</a>
       	&nbsp;&nbsp;&nbsp;
       	<a href="list">List All Users</a>
       	
      	</h2>
    <div align="center">
        <table border="1">
            <caption>List of Empleados</caption>
            <tr>
                <th>NOMBRE</th>
                <th>DNI</th>
                <th>SEXO</th>
                <th>CATEGORIA</th>
                <th>ANYOS</th>
                <th>Acciones</th>
            </tr>
            <c:forEach var="empleado" items="${listEmpleado}">
                <tr>
                    <td><c:out value="${empleado.nombre}" /></td>
                    <td><c:out value="${empleado.dni}" /></td>
                    <td><c:out value="${empleado.sexo}" /></td>
                    <td><c:out value="${empleado.categoria}" /></td>
                    <td><c:out value="${empleado.anyos}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${empleado.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${empleado.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>