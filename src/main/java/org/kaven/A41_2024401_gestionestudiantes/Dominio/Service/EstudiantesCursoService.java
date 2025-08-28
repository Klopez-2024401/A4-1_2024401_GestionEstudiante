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
    public List<EstudiantesCurso> buscarPorEstudianteId(Integer codigo) {
        return crud.findByEstudiante_Idestudiantes(codigo);
    }

    @Override
    public List<EstudiantesCurso> buscarPorEstudianteCorreo(String correo) {
        return crud.findByEstudiante_Correo(correo);
    }

    @Override
    public EstudiantesCurso guardarEstudiantesCurso(EstudiantesCurso estCurso) {
        return crud.save(estCurso);
    }

}
