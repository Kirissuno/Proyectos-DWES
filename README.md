# Proyectos-DWES

BBDD empleados :
    create database empleados;
    use empleados;

    create table Empleados ( 
        Nombre varchar(255),
        DNI varchar(255) primary key,
        Sexo varchar(1),
        Categoria int,
        Anyos int);
        
     create table Nominas(
	      DNI varchar(255) primary key references Empleados,
        Sueldo int);
        
        
