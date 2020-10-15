package com.gestor.instituto.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class Alumno extends Usuario{


    public Alumno(long id, String email, String password, String nombre, String apellidos, String dni, String numeroTlf, LocalDate fecha_nac) {
        super(id, email, password, nombre, apellidos, dni, numeroTlf, fecha_nac);
    }




}
