package com.gestor.instituto.service;

import com.gestor.instituto.models.Horario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HorarioService {


    public List<List<Horario>> ordernarFinal (List<Horario> lista){
        List<List<Horario>> listaF = new ArrayList<>();
        for (int i=1;i<7;i++){
            listaF.add(this.ordenar(this.listaTramo(lista,i)));
        }
        return listaF;
    }
    public List<Horario> ordenar (List<Horario> lista){
        lista=lista.stream().sorted(Comparator.comparingInt(Horario::getDia))
                .collect(Collectors.toList());
        return lista;
    }
    public List<Horario> listaTramo(List<Horario> lista, int dia){
        List<Horario> listaF = new ArrayList<>();
        for (Horario h :lista){
            if (h.getTramo()==dia){
                listaF.add(h);
            }
        }
        return listaF;
    }



}
