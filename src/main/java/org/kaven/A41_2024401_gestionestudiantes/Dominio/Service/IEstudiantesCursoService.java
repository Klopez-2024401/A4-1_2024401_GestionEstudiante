package org.kaven.A41_2024401_gestionestudiantes.Dominio.Service;

import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.EstudiantesCurso;

import java.util.List;

public interface IEstudiantesCursoService {
    List<EstudiantesCurso> listarEstudiantesCurso();
    List<EstudiantesCurso> buscarPorEstudianteId(Integer codigo);
    List<EstudiantesCurso> buscarPorEstudianteCorreo(String correo);
    EstudiantesCurso guardarEstudiantesCurso(EstudiantesCurso estCurso);
}
