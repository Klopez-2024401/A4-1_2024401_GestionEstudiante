package org.kaven.A41_2024401_gestionestudiantes.Dominio.Service;

import org.kaven.A41_2024401_gestionestudiantes.persistence.crud.CursosCrud;
import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.Cursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursosService implements ICursosService{

    @Autowired
    private CursosCrud crud;

    @Override
    public List<Cursos> listarCursos() {
        List<Cursos> cursos = (List<Cursos>) crud.findAll();
        return cursos;
    }
}
