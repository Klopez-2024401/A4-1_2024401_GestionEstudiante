package org.kaven.A41_2024401_gestionestudiantes;

import org.kaven.A41_2024401_gestionestudiantes.Dominio.Service.CursosService;
import org.kaven.A41_2024401_gestionestudiantes.Dominio.Service.ICursosService;
import org.kaven.A41_2024401_gestionestudiantes.Dominio.Service.IEstudianteService;
import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.Cursos;
import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.Estudiantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class A412024401GestionestudiantesApplication implements CommandLineRunner {

	@Autowired
	private IEstudianteService estudianteService;
	private static final Logger logger = LoggerFactory.getLogger(A412024401GestionestudiantesApplication.class);
	String sl = System.lineSeparator();


	public static void main(String[] args) {
		logger.info("AQUI INICIA NUESTRA APLICACION");
		SpringApplication.run(A412024401GestionestudiantesApplication.class, args);
		logger.info("AQUI TERMINA LA APLICACION");
	}

	@Override
	public void run(String... args) throws Exception {
		A412024401GestionestudiantesApplication();
	}

	public void A412024401GestionestudiantesApplication() {
		logger.info("Aplicacion de registrar Estudiantes");
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir) {
			var opcion = mostrarMenu(consola);
			salir = ejecutarOpciones(consola, opcion);
			logger.info(sl);
		}
	}
	private int mostrarMenu(Scanner consola) {
		logger.info("""
                \n***Aplicacion***
                1. Listado de todos los estudiantes.
                2. Buscar Estudiantes por codigo.
                3. Agregar nuevo Estudiantes.
                4. Modificar los datos de Estudiantes.
                5. Dar de baja a Estudiante.
                6. Mostar notas de los Cursos de estudiantes.
                7. Salir.
                Elija una opcion: \s""");
		var opcion = Integer.parseInt(consola.nextLine());
		return opcion;
	}
	private boolean ejecutarOpciones(Scanner consola, int opcion) {
		var salir = false;
		switch (opcion) {
			case 1 -> {
				logger.info(sl+"***Listado de todos los estudiantes.***"+sl);
				List<Estudiantes> estudiantes = estudianteService.listarEstudiantes();
				estudiantes.forEach(estudiante -> logger.info(estudiante.toString()+sl));
			}
			case 2 -> {
				logger.info(sl+"***Busca Estudiante por codigo***"+sl);
				logger.info("""
                        ¿Como desea buscarlo por id o por correo?
                        Escriba la opcion porfavor
                        """);
				String elegir = consola.nextLine();
				if ("id".equalsIgnoreCase(elegir)) {
					logger.info("Ingrese el codigo del Estudiante");
					int codigo = Integer.parseInt(consola.nextLine());
					Estudiantes estudiantes = estudianteService.buscarEstudiantes(codigo);
					if (estudiantes != null) {
						logger.info("Estudiante encontrado:" + sl + estudiantes + sl);
					}else{
						logger.info("Estudiante no encontrado");
					}
				}else if ("correo".equalsIgnoreCase(elegir)) {
					logger.info("Ingrese el correo del Estudiante");
					String correo = consola.nextLine();
					Estudiantes estudiantes = estudianteService.buscarEstudiantescorreo(correo);

					if (estudiantes != null) {
						logger.info("Estudiante encontrado:" + sl + estudiantes + sl);
					}else{
						logger.info("Estudiante no encontrado");
					}
				}else{
					logger.info("Opcion no encontrada debe escribir ID o CORREO SI O SI");
				}
			}
			case 3 -> {
				logger.info(sl+"***Agregar nuevo Estudiante***"+sl);
				logger.info("Ingrese el nombre: ");
				var nombre = consola.nextLine();
				logger.info("Ingrese el apellido: ");
				var apellido = consola.nextLine();
				logger.info("Ingrese el correo: ");
				var correo = consola.nextLine();
				logger.info("Ingrese nombre del curso para inscribirse");
				var inscrito = consola.nextLine();

				var estudiante = new Estudiantes();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setCorreo(correo);
				estudiante.setInscrito(inscrito);
				estudianteService.guardarEstudiantes(estudiante);
				logger.info("Estudiante agregado: " + sl + estudiante + sl);
			}
			case 4 -> {
				logger.info(sl+"***Modificar los datos de Estudiante***"+sl);
				logger.info("Ingrese el codigo del Estudiante");
				var codigo = Integer.parseInt(consola.nextLine());
				Estudiantes estudiante = estudianteService.buscarEstudiantes(codigo);
				if (estudiante != null) {
					logger.info("Ingrese el nombre: ");
					var nombre = consola.nextLine();
					logger.info("Ingrese el apellido: ");
					var apellido = consola.nextLine();
					logger.info("Ingrese el correo: ");
					var correo = consola.nextLine();
					logger.info("Ingrese el nuevo curso que quiere Inscribirse: ");
					var inscrito = consola.nextLine();

					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setCorreo(correo);
					estudiante.setInscrito(inscrito);
					estudianteService.guardarEstudiantes(estudiante);
					logger.info("Estudiante modificado: " + sl + estudiante + sl);
				}else{
					logger.info("Estudiante no encontrado:"+ sl + estudiante + sl);
				}

			}
			case 5 -> {
				logger.info(sl+"***Dar de baja a Estudiante***"+sl);
				logger.info("Ingrese el codigo del Estudiante");
				var codigo = Integer.parseInt(consola.nextLine());
				var estudiante = estudianteService.buscarEstudiantes(codigo);
				if (estudiante != null) {
					estudianteService.eliminarEstudiantes(estudiante);
					logger.info("Estudiantes dado de baja: " + sl + estudiante + sl);
				}else{
					logger.info("Estudiantes no encontrado"+ sl + estudiante + sl);
				}
			}
			case 6 ->{
				logger.info("***Mostar notas de los Cursos de estudiantes.***");
				List<Cursos> cursos = cursosService.listarCursos();
				cursos.forEach(cursos -> logger.info(cursos.toString()+sl));
			}
			case 7 -> {
				logger.info(sl+"***Salir del programa***"+sl);
				salir = true;
			}
			default -> logger.info("opcion no valida");
		}
		return salir;
	}
}





