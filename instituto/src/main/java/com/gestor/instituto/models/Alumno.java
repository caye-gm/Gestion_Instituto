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




    // Mantenemos esta lista, pero no añadimos helpers
    // Si queremos rellenar la lista, realizamos un JOIN FETCH
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy="alumno", fetch = FetchType.EAGER)
    private List<SituacionExepcional> situacionExepcional = new ArrayList<>();


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy="alumno", fetch = FetchType.EAGER)
    private List<SolicitudAmpliacionMatricula> SolicitudAmpliacionMatricula = new ArrayList<>();





    public Alumno(long id, String email, String password, String nombre, String apellidos, String dni, String numeroTlf, LocalDate fecha_nac) {
        super(id, email, password, nombre, apellidos, dni, numeroTlf, fecha_nac);
    }




}
