drop database if exists Registro_Estudiante;
create database Registro_Estudiante;
use Registro_Estudiante;

create table Estudiantes(
idestudiantes int auto_increment,
nombre varchar(50),
apellido varchar(50),
correo varchar(50),
constraint pk_estudiantes primary key(idestudiantes)
);

create table Cursos(
	idcursos int auto_increment,
	nombrecursos varchar(50) unique,
    constraint pk_cursos primary key(idcursos)
);

create table Estudiantecurso(
	idestudiantes int,
    idcursos int,
    nota decimal(5,2),
    constraint pk_estudiantecursos primary key(idestudiantes, idcursos),
    constraint fk_estudiantecursos_estudiantes foreign key(idestudiantes)
		references Estudiantes(idestudiantes) on delete cascade,
	constraint fk_estudiantecursos_cursos foreign key(idcursos) 
		references Cursos(idcursos) on delete cascade
);

insert into Estudiantes (nombre, apellido, correo) values
('Alfredo','Perez','AlPerez@gmail.com'),
('Maria','Lopez','mlopez@gmail.com');

insert into Cursos (nombrecursos) values
('Fisica'), 
('Matematicas');

insert into EstudianteCurso (idestudiantes, idcursos, nota) values
(1,1,57.0),  
(2,2,85.0);

select * from Estudiantes;
select * from Cursos;
select * from EstudianteCurso;

select 
    e.nombre as Nombre,
    e.apellido as Apellido,
    e.correo as Correo,
    c.nombrecursos as Curso,
    ec.nota as Nota
from EstudianteCurso ec
join Estudiantes e on ec.idestudiantes = e.idestudiantes
join Cursos c on ec.idcursos = c.idcursos;

