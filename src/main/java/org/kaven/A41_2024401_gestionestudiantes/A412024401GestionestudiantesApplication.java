package org.kaven.A41_2024401_gestionestudiantes;


import org.kaven.A41_2024401_gestionestudiantes.Dominio.Service.IEstudianteService;
import org.kaven.A41_2024401_gestionestudiantes.Dominio.Service.IEstudiantesCursoService;
import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.Cursos;
import org.kaven.A41_2024401_gestionestudiantes.Dominio.Service.ICursosService;
import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.Estudiantes;
import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.EstudiantesCurso;
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
    @Autowired
    private ICursosService cursosService;
    @Autowired
    private IEstudiantesCursoService estudiantesCursoService;
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
                6. Agregar Curso.
                7. Ver datos completos de los estudiantes.
                8. Salir.
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
                    List<EstudiantesCurso> lista = estudiantesCursoService.buscarPorEstudianteId(codigo);

                    if (!lista.isEmpty()) {
                        lista.forEach(ec -> logger.info("Nombre: {} {}, Correo: {}, Curso: {}, Nota: {}",
                                ec.getEstudiantes().getNombre(),
                                ec.getEstudiantes().getApellido(),
                                ec.getEstudiantes().getCorreo(),
                                ec.getCursos().getNombrecursos(),
                                ec.getNota()
                        ));
                    } else {
                        logger.info("Estudiante no encontrado");
                    }
				}else if ("correo".equalsIgnoreCase(elegir)) {
					logger.info("Ingrese el correo del Estudiante");
					String correo = consola.nextLine();
                    List<EstudiantesCurso> lista = estudiantesCursoService.buscarPorEstudianteCorreo(correo);

                    if (!lista.isEmpty()) {
                        lista.forEach(ec -> logger.info("Nombre: {} {}, Correo: {}, Curso: {}, Nota: {}",
                                ec.getEstudiantes().getNombre(),
                                ec.getEstudiantes().getApellido(),
                                ec.getEstudiantes().getCorreo(),
                                ec.getCursos().getNombrecursos(),
                                ec.getNota()
                        ));
                    } else {
                        logger.info("Estudiante no encontrado");
                    }

                } else {
                    logger.info("Opción no válida, debe escribir 'id' o 'correo'");
				}
			}
			case 3 -> {
                logger.info(sl + "***Agregar nuevo Estudiante***" + sl);
                logger.info("Ingrese el nombre: ");
                var nombre = consola.nextLine();
                logger.info("Ingrese el apellido: ");
                var apellido = consola.nextLine();
                logger.info("Ingrese el correo: ");
                var correo = consola.nextLine();

                var estudiante = new Estudiantes();
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);
                estudiante.setCorreo(correo);
                estudianteService.guardarEstudiantes(estudiante);

                logger.info("Estudiante agregado: " + sl + estudiante + sl);

                logger.info("Cursos disponibles:");
                List<Cursos> cursosDisponibles = cursosService.listarCursos();
                for (Cursos curso : cursosDisponibles) {
                    logger.info(curso.getIdcursos() + " - " + curso.getNombrecursos());
                }
                logger.info("Ingrese el ID del curso que desea inscribirse:");
                int idCurso = Integer.parseInt(consola.nextLine());
                String nombreCursoSeleccionado = "";
                for (Cursos curso : cursosDisponibles) {
                    if (curso.getIdcursos() == idCurso) {
                        nombreCursoSeleccionado = curso.getNombrecursos();
                        break;
                    }
                }
                if (!nombreCursoSeleccionado.isEmpty()) {
                    logger.info("Te has inscrito al curso: " + nombreCursoSeleccionado);
                } else {
                    logger.info("ID de curso no válido.");
                }
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

					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setCorreo(correo);
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
                logger.info("Ingresar curso existente");
                logger.info("Ingrese el curso: ");
                var nombrecursos = consola.nextLine();

                var cursos = new Cursos();
                cursos.setNombrecursos(nombrecursos);

                try {
                    cursosService.guardarCurso(cursos);
                    logger.info("Curso agregado: " + cursos);
                } catch (IllegalArgumentException e) {
                    logger.info("Error"+ e.getMessage());
                }
            }
            case 7 -> {
                logger.info("Listado de Datos completos de estudiantes");
                List<EstudiantesCurso> estudiantesCursos = estudiantesCursoService.listarEstudiantesCurso();
                estudiantesCursos.forEach(estudiantecurso ->
                        logger.info("Nombre: {} {}, Correo: {}, Curso: {}, Nota: {}",
                                estudiantecurso.getEstudiantes().getNombre(),
                                estudiantecurso.getEstudiantes().getApellido(),
                                estudiantecurso.getEstudiantes().getCorreo(),
                                estudiantecurso.getCursos().getNombrecursos(),
                                estudiantecurso.getNota())
                );
            }
			case 8 -> {
				logger.info(sl+"***Salir del programa***"+sl);
				salir = true;
			}
			default -> logger.info("opcion no valida");
		}
		return salir;
	}
}





