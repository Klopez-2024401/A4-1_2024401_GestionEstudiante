package org.kaven.A41_2024401_gestionestudiantes.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.kaven.A41_2024401_gestionestudiantes.Dominio.Service.ICursosService;
import org.kaven.A41_2024401_gestionestudiantes.Dominio.Service.IEstudianteService;
import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.Cursos;
import org.kaven.A41_2024401_gestionestudiantes.persistence.entity.Estudiantes;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@ViewScoped
public class IndexController {

    @Autowired
    IEstudianteService estudianteService;
    @Autowired
    ICursosService cursosService;

    private List<Estudiantes> estudiantes;
    private List<Cursos> cursos;
    private Estudiantes estudianteSeleccionada;
    private Cursos cursoSeleccionada;
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @PostConstruct
    public void init() {
        cargarDatos();
    }

    public void cargarDatos() {
        this.estudiantes = this.estudianteService.listarEstudiantes();
        this.estudiantes.forEach(estudiante -> logger.info(estudiante.getNombre()));
    }

    public void agregarEstudiante() {
        this.estudianteSeleccionada = new Estudiantes();
    }

    public void agregarCurso(){
        this.cursoSeleccionada = new Cursos();
    }

    public void guardarCurso() {
        logger.info("Curso guardado:" + this.cursoSeleccionada);
        if (this.cursoSeleccionada.getIdcursos() == null) {
            this.cursosService.guardarCurso((this.cursoSeleccionada));
            if (this.cursos == null) {
                this.cursos = new ArrayList<>();
            }
            this.cursos.add(this.cursoSeleccionada);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Curso Agregado"));
        }
    }


    public void guardarEstudiantes() {
        logger.info("Estudiante a guardar:" + this.estudianteSeleccionada);
        if (this.estudianteSeleccionada.getIdestudiantes() == null) {
            this.estudianteService.guardarEstudiantes(this.estudianteSeleccionada);
            this.estudiantes.add(this.estudianteSeleccionada);
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Estudiante Agregado"));
        } else {
            this.estudianteService.guardarEstudiantes(this.estudianteSeleccionada);
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Estudiante Actualizado"));
            PrimeFaces.current().executeScript("PF('ventanaModalEstudiante').hide()");
            PrimeFaces.current().ajax().update("formulario-estudiantes:mensaje_emergente",
                    "formulario-estudiantes:tabla-estudiantes");
            this.estudianteSeleccionada = null;
        }
    }

    public void eliminarEstudiante(){
        logger.info("Estudiante a eliminar: "+this.estudianteSeleccionada);
        this.estudianteService.eliminarEstudiantes(estudianteSeleccionada);
        this.estudiantes.remove(estudianteSeleccionada);
        this.estudianteSeleccionada = null;
        FacesContext.getCurrentInstance().addMessage(
                null , new FacesMessage("Estudiante eliminado"));
        PrimeFaces.current().ajax().update(
                "formulario-estudiantes:mensaje_emergente",
                "formulario-estudiantes:tabla-estudiantes");
    }

}
