package org.kaven.A41_2024401_gestionestudiantes.persistence.crud;

import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursosCrud  extends JpaRepository<Cursos, Integer> {
}
