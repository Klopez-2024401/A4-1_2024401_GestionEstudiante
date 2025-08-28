package org.kaven.A41_2024401_gestionestudiantes.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Cursos",
    uniqueConstraints = {
    @UniqueConstraint(name = "uq_nombrecursos", columnNames = "nombrecursos")
    })
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
    @Column(name = "nombrecursos", length = 50, nullable = false, unique = true)
    private String nombrecursos;

}
