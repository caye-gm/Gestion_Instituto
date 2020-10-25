package com.gestor.instituto.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor@AllArgsConstructor
public class Horario implements Comparable<Horario>{


    @Id@GeneratedValue
    private Long id;
    private int dia;
    private int tramo;
    private boolean esAlta;

    @ManyToOne
    private Asignatura asignatura;

    public Horario(int dia, int tramo, boolean esAlta, Asignatura asignatura) {
        this.dia = dia;
        this.tramo = tramo;
        this.esAlta = esAlta;
        this.asignatura = asignatura;
    }

    public Horario(int dia, int tramo, boolean esAlta) {
        this.dia = dia;
        this.tramo = tramo;
        this.esAlta = esAlta;

    }

    @Override
    public int compareTo(Horario h){
        int numP=1,numN=-1;
        if (this.getTramo() < h.getTramo()){
            return  numP;
        }else{
            return numN;
        }
    }





}
