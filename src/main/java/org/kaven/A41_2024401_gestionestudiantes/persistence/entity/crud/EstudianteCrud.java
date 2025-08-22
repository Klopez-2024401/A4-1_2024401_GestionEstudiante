package org.kaven.A41_2024401_gestionestudiantes.persistence.entity.crud;

import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.entity.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteCrud extends JpaRepository<Estudiantes, Integer> {
}
