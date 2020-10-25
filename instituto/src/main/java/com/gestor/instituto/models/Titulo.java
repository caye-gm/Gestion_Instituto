package com.gestor.instituto.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor@AllArgsConstructor
public class Titulo {
    @Id@GeneratedValue
    private Long id;

    private String nombre;
    private boolean estado;
    public Titulo(String nombre, List<Curso> curso) {
        this.nombre = nombre;
        this.curso = curso;
    }

    //asosiacion fuerte con curso
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy="titulo", fetch = FetchType.EAGER)
    private List<Curso> curso = new ArrayList<>();

    public Titulo(String nombre, boolean estado, List<Curso> curso) {
        this.nombre = nombre;
        this.estado = estado;
        this.curso = curso;
    }

    //helpers
    public void addCurso(Curso c) {
        c.setTitulo(this);
        this.curso.add(c);
    }
    public void removeCurso(Curso c) {
        this.curso.remove(c);
        c.setTitulo(null);
    }


}
