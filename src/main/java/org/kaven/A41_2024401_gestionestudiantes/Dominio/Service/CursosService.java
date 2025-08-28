package org.kaven.A41_2024401_gestionestudiantes.Dominio.Service;

import lombok.RequiredArgsConstructor;
import org.kaven.A41_2024401_gestionestudiantes.persistence.crud.CursosCrud;
import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.Cursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CursosService implements ICursosService{

    private final CursosCrud crud;

    @Override
    public void guardarCurso(Cursos cursos) {
        if (crud.findByNombrecursosIgnoreCase(cursos.getNombrecursos()).isPresent()) {
            throw new IllegalArgumentException(
                    "El curso '" + cursos.getNombrecursos() + "' ya existe. Ingrese otro."
            );
        }
        crud.save(cursos);
    }

    @Override
    public List<Cursos> listarCursos() {
        return crud.findAll();
    }

    @Override
    public Cursos buscarCurso(Integer idCurso) {
        return crud.findById(idCurso).orElse(null);
    }


}
