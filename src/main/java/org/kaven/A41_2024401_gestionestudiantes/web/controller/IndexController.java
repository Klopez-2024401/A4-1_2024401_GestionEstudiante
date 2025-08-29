package org.kaven.A41_2024401_gestionestudiantes.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.kaven.A41_2024401_gestionestudiantes.Dominio.Service.IEstudianteService;
import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.Estudiantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class IndexController {

    @Autowired
    IEstudianteService estudianteService;
    private List<Estudiantes> estudiantes;
    private Estudiantes estudianteSeleccionada;
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.estudiantes = this.estudianteService.listarEstudiantes();
        this.estudiantes.forEach(estudiante -> logger.info(estudiante.getNombre()));
    }
    public void agregarEstudiante(){
        this.estudianteSeleccionada = new Estudiantes();
    }
}
