package org.kaven.A41_2024401_gestionestudiantes.Dominio.Service;


import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.Estudiantes;
import java.util.List;

public interface IEstudianteService {
    List<Estudiantes> listarEstudiantes();
    Estudiantes buscarEstudiantes(Integer codigo);
    Estudiantes buscarEstudiantescorreo(String correo);
    void guardarEstudiantes(Estudiantes estudiantes);
    void eliminarEstudiantes(Estudiantes estudiantes);

}
