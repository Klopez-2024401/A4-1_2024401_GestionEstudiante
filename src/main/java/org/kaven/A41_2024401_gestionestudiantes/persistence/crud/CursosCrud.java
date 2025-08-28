package org.kaven.A41_2024401_gestionestudiantes.persistence.crud;

import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursosCrud  extends JpaRepository<Cursos, Integer> {
    Optional<Cursos> findByNombrecursosIgnoreCase(String nombrecursos);
}
