package org.kaven.A41_2024401_gestionestudiantes.persistence.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EstudianteCursoId implements Serializable{
    private Integer idestudiantes;
    private Integer idcursos;
}
