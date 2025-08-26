drop database if exists Registro_Estudiante;
create database Registro_Estudiante;
use Registro_Estudiante;

create table Estudiantes(
idestudiantes int auto_increment,
nombre varchar(50),
apellido varchar(50),
correo varchar(50),
inscrito varchar(50),
constraint pk_estudiantes primary key(idestudiantes)
);

create table Cursos(
	idcurso int auto_increment,
    nota int,
    idestudiantes int,
    constraint pk_cursos primary key(idcurso),
    constraint fk_cursos_estudiantes foreign key (idestudiantes)
		references Estudiantes(idestudiantes)
);

insert into Estudiantes (nombre, apellido, correo, inscrito) values
('Alfredo','Perez','AlPerez@gmail.com','Fisica');

insert into Cursos(nota, idestudiantes) values
('57',1);

select * from Estudiantes;

select * from 	Cursos;
