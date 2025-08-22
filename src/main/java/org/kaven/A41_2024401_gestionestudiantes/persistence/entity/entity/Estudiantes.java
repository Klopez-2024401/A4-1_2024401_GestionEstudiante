package org.kaven.A41_2024401_gestionestudiantes.persistence.entity.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Esutidantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Estudiantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdEstudiantes;
    @Column
    private String nombre;
    private String apellido;
    private String correo;
}

