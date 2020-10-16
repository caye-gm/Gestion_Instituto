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

    //asosiacion fuerte con curso
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy="titulo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Curso> curso = new ArrayList<>();
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
