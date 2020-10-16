package com.gestor.instituto.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor@NoArgsConstructor
public class Curso {
    @Id@GeneratedValue
    private Long id;

    private int numCurso;
    private String nombre;
    private String anio;
    private Boolean estado;

    //one to many con alumno
    @OneToMany(mappedBy="curso")
    private List<Alumno> alumnos;
    //Helpers
    public void addAlumno(Alumno a) {
        this.alumnos.add(a);
        a.setCurso(this);
    }
    public void removeAlumno(Alumno a) {
        this.alumnos.remove(a);
        a.setCurso(null);
    }

    //asosiacion fuerte
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy="curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asignatura> asignaturas = new ArrayList<>();
    //helpers
    public void addAsignatura(Asignatura a) {
        a.setCurso(this);
        this.asignaturas.add(a);
    }
    public void removeAsignatura(Asignatura a) {
        this.asignaturas.remove(a);
        a.setCurso(null);
    }

    //ASOSIACION A TITULO
    @ManyToOne
    private Titulo titulo;




    public Curso(int numCurso, String nombre, String anio) {
        this.numCurso = numCurso;
        this.nombre = nombre;
        this.anio = anio;
    }

    public Curso(int numCurso, String nombre, String anio, List<Alumno> alumnos) {
        this.numCurso = numCurso;
        this.nombre = nombre;
        this.anio = anio;
        this.alumnos = alumnos;
    }
}
