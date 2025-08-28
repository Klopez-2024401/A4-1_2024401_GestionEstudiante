package org.kaven.A41_2024401_gestionestudiantes.Dominio.Service;

import org.kaven.A41_2024401_gestionestudiantes.persistence.crud.EstudiantesCursoCrud;
import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.EstudiantesCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudiantesCursoService implements IEstudiantesCursoService{

    @Autowired
    private EstudiantesCursoCrud crud;

    @Override
    public List<EstudiantesCurso> listarEstudiantesCurso() {
        List<EstudiantesCurso> estudiantesCurso = (List<EstudiantesCurso>) crud.findAll();
        return estudiantesCurso;
    }

    @Override
    public EstudiantesCurso buscarPorEstudianteId(Integer codigo) {
        EstudiantesCurso estudiantesCurso = crud.findById(codigo).orElse(null);
        return estudiantesCurso;
    }
}
