package com.gestor.instituto.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asignatura {

    @Id@GeneratedValue
    private Long id;
    private String nombreAsig;


    // Mantenemos esta lista, pero no añadimos helpers
    // Si queremos rellenar la lista, realizamos un JOIN FETCH
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy="asignatura", fetch = FetchType.EAGER)
    private List<SituacionExepcional> situacionExepcional = new ArrayList<>();

    //onetomany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy="asignatura", fetch = FetchType.EAGER)
    private List<SolicitudAmpliacionMatricula> solicitudAmpliacionMatricula = new ArrayList<>();

    //many to one a curso
    @ManyToOne
    private Curso curso;




}