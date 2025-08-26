package org.kaven.A41_2024401_gestionestudiantes.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Cursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcursos")
    private Integer idcursos;
    @Column(name = "nota")
    private Integer nota;
    @Column(name = "seccion")
    private String seccion;
    @Column(name = "idestudiantes")
    private Integer idestudiantes;

}
