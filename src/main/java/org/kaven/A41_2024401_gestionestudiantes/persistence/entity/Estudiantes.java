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
    @Column(name = "idestudiantes")
    private Integer idestudiantes;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "correo")
    private String correo;
}

