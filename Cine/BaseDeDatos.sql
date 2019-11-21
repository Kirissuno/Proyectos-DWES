create database cine;
use cine;
create table pelicula(
	director varchar(128),
    titulo varchar(128) primary key not null unique,
    fecha date not null);
    
insert into pelicula values ('Alpachino', 'Torino', '1997-04-19');
insert into pelicula values ('Ni idea', 'Gran Torino', '1997-04-19');
insert into pelicula values ('No se', 'Toy Story', '200-04-18');