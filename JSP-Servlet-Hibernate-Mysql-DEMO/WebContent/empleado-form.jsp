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
		<c:if test="${empleado != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${empleado == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${empleado != null}">
            			Editar empleado
            		</c:if>
            		<c:if test="${empleado == null}">
            			Añadir nuevo empleado
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${empleado != null}">
        			<input type="hidden" name="id" value="<c:out value='${empleado.dni}' />" />
        		</c:if>            
            <tr>
                <th>Nombre de empleado: </th>
                <td>
                	<input type="text" name="name" size="45"
                			value="<c:out value='${empleado.nombre}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Sexo: </th>
                <td>
                	<input type="text" name="sexo" size="45"
                			value="<c:out value='${empleado.sexo}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Categoria: </th>
                <td>
                	<input type="text" name="categoria" size="15"
                			value="<c:out value='${empleado.categoria}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Anyos: </th>
                <td>
                	<input type="text" name="anyos" size="15"
                			value="<c:out value='${empleado.anyos}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>