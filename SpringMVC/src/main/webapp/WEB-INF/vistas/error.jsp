<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page session="false"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body style="background-image: linear-gradient(to right, #9EBDB3, #37B9E9);">
<div class="container">
	<div class="row text-center">
		<h1 style="color:red">${message}</h1>
	</div>
	<hr>
	<div class="row justify-content-center">
		<h3>También te puede dar error por alguna de las siguientes causas: </h3>
	</div>
	<div class="row">
		<ul style="color: rgb(255,91,91)">
			<li>Tu base de datos está mal</li>
			<li>No sabes programar</li>
			<li>Cuidado con los espacios que introduzcas, esto no tiene trim :(</li>
		</ul>
	</div>	
		<hr>
	<div class="row">
		<p>La base de datos a usar es la siguiente: </p>
	</div>
	<div class="row ml-5">
		<p>Nombre base de datos: <b>"nominas"</b></p>
	</div>
	<div class="row">
		<p>Contiene 2 tablas: </p>
	</div>
	<div class="row">
		<p>Tabla 1:</p>
	</div>
	<div class="row ml-5">
		<b>create table empleados ( <br>
	    Nombre varchar(255), <br>
	    DNI varchar(255) primary key, <br>
	    Sexo varchar(1), <br>
	    Categoria int, <br>
	    Anyos int);</b>
    </div>
    <div class="row">
	    <p>Tabla 2:</p> 
    </div>
    <div class="row ml-5">
	    <b>create table nominas( <br>
	      DNI varchar(255) primary key references empleados, <br>
	    Sueldo int);</b> 
	    
    </div>
</div>
    <hr>	
	<a href="/">
		<button class="btn btn-primary">Volver al index</button>
	</a>
</body>
</html>