package org.kaven.A41_2024401_gestionestudiantes.Dominio.Service;

import org.kaven.A41_2024401_gestionestudiantes.persistence.crud.EstudianteCrud;
import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.Estudiantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteService implements IEstudianteService {

    @Autowired
    private EstudianteCrud crud;

    @Override
    public List<Estudiantes> listarEstudiantes() {
        List<Estudiantes> estudiantes = (List<Estudiantes>) crud.findAll();
        return estudiantes;
    }

    @Override
    public Estudiantes buscarEstudiantes(Integer codigo) {
        Estudiantes estudiantes = crud.findById(codigo).orElse(null);
        return estudiantes;
    }

    @Override
    public Estudiantes buscarEstudiantescorreo(String correo) {
        Estudiantes estudiantes = crud.findByCorreo(correo);
        return estudiantes;
    }


    @Override
    public void guardarEstudiantes(Estudiantes estudiantes) {
        crud.save(estudiantes);
    }

    @Override
    public void eliminarEstudiantes(Estudiantes estudiantes) {
        crud.delete(estudiantes);
    }
}
