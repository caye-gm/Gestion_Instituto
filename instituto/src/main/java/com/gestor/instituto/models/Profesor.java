package com.gestor.instituto.models;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class Profesor extends Usuario{

    private boolean esJefeDeEstudio;

    public Profesor(long id, String email, String password, String nombre, String apellidos, String dni, String numeroTlf, LocalDate fecha_nac, boolean esJefeDeEstudio) {
        super(id, email, password, nombre, apellidos, dni, numeroTlf, fecha_nac);
        this.esJefeDeEstudio = esJefeDeEstudio;
    }
}
