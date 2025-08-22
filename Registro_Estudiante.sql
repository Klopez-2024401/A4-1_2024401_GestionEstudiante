create database Registro_Estudiante;
use Registro_Estudiante;

create table Estudiantes(
IdEstudiantes int auto_increment,
nombre varchar(50),
apellido varchar(50),
correo varchar(50),
constraint pk_estudiantes primary key(IdEstudiantes)
);

create table Califiacion(
	IdCalificacion int auto_increment,
    materia varchar(50),
    nota int,
    seccion varchar(50),
    constraint pk_calificacion primary key(IdCalificacion)
);

insert into Estudiantes (nombre, apellido, correo) values
('Alfredo','Perez','AlPerez@gmail.com')