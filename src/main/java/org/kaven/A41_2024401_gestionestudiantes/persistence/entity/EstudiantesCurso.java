package org.kaven.A41_2024401_gestionestudiantes.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Estudiantecurso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class EstudiantesCurso {

    @EmbeddedId
    private EstudianteCursoId id;

    @ManyToOne
    @MapsId("idestudiantes")
    @JoinColumn(name = "idestudiantes")
    private Estudiantes estudiante;

    @ManyToOne
    @MapsId("idcursos")
    @JoinColumn(name = "idcursos")
    private Cursos cursos;

    @Column(name = "nota")
    private Double nota;


}
