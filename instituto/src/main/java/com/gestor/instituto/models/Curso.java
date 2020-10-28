package com.gestor.instituto.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor@NoArgsConstructor
@Builder
public class Curso {
    @Id@GeneratedValue
    private Long id;


    private String nombre;


    public Curso( String nombre, Boolean estado, Titulo titulo) {

        this.nombre = nombre;

        this.estado = estado;
        this.titulo = titulo;
    }

    public Curso( String nombre, Boolean estado, List<Alumno> alumnos, List<Asignatura> asignaturas, Titulo titulo) {

        this.nombre = nombre;

        this.estado = estado;
        this.alumnos = alumnos;
        this.asignaturas = asignaturas;
        this.titulo = titulo;
    }

    private Boolean estado;

    //one to many con alumno
    @OneToMany(mappedBy="curso",fetch = FetchType.EAGER)
    private List<Alumno> alumnos = new ArrayList<>();

    public Curso(String nombre, Boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

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
    @OneToMany(mappedBy="curso", fetch = FetchType.EAGER)
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




    public Curso(String nombre) {

        this.nombre = nombre;

    }

    public Curso(String nombre, Boolean estado, List<Alumno> alumnos, List<Asignatura> asignaturas) {
        this.nombre = nombre;
        this.estado = estado;
        this.alumnos = alumnos;
        this.asignaturas = asignaturas;
    }

    public Curso(String nombre, List<Alumno> alumnos) {

        this.nombre = nombre;

        this.alumnos = alumnos;
    }
}
