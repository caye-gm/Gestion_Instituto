package com.gestor.instituto.service;

import com.gestor.instituto.models.Asignatura;
import com.gestor.instituto.models.Curso;
import com.gestor.instituto.models.Horario;
import com.gestor.instituto.models.Profesor;
import com.gestor.instituto.repository.HorarioRepository;
import com.gestor.instituto.repository.ProfesorRepository;
import com.gestor.instituto.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HorarioService extends BaseService<Horario,Long, HorarioRepository> {


    public HorarioService(HorarioRepository repo) {
        super(repo);
    }

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

    public List<Horario> horario(Curso curso){
        List<Horario> horario=new ArrayList<>();
        for (int i = 0; i < curso.getAsignaturas().size(); i++) {
            Asignatura a=curso.getAsignaturas().get(i);
            for (int j = 0; j < a.getHorario().size(); j++) {

                horario.add(a.getHorario().get(j));
            }

        }
        return horario;
    }

}
