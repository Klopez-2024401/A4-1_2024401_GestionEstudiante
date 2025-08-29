package org.kaven.A41_2024401_gestionestudiantes.persistence.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Estudiantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Estudiantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idestudiantes;
    private String nombre;
    private String apellido;
    private String correo;
}

