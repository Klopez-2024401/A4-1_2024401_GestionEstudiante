package org.kaven.A41_2024401_gestionestudiantes.persistence.crud;

import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteCrud extends JpaRepository<Estudiantes, Integer> {

    Estudiantes findByCorreo(String correo);
}
