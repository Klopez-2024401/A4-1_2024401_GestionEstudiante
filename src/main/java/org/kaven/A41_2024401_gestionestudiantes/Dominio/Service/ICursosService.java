package org.kaven.A41_2024401_gestionestudiantes.Dominio.Service;

import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.Cursos;

import java.util.List;

public interface ICursosService {

    void guardarCurso(Cursos cursos);
    List<Cursos> listarCursos();
    Cursos buscarCurso(Integer idCurso);
}
