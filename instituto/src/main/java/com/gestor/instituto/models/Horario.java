package com.gestor.instituto.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;


@Data
@NoArgsConstructor@AllArgsConstructor
public class Horario implements Comparable<Horario>{
    private Long id;
    private int dia;
    private int tramo;
    private boolean esAlta;



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
