package org.kaven.A41_2024401_gestionestudiantes.persistence.crud;

import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.EstudianteCursoId;
import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.EstudiantesCurso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstudiantesCursoCrud extends JpaRepository<EstudiantesCurso, EstudianteCursoId>{
    List<EstudiantesCurso> findByEstudiante_Idestudiantes(Integer idEstudiantes);
    List<EstudiantesCurso> findByEstudiante_Correo(String correo);


}
