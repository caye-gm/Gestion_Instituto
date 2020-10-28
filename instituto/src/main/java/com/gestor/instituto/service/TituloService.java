package com.gestor.instituto.service;

import com.gestor.instituto.models.*;
import com.gestor.instituto.repository.ProfesorRepository;
import com.gestor.instituto.repository.TituloRepository;
import com.gestor.instituto.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TituloService extends BaseService<Titulo,Long, TituloRepository> {
    public TituloService(TituloRepository repo) {
        super(repo);
    }

    @Autowired
    CursoService cursoService;
    @Autowired
    AlumnoService alumnoService;
    @Autowired
    AsignaturaService asignaturaService;
    @Autowired
    TituloService tituloService;

    public void tituloFalse(Titulo titulo,List<Curso> cursos,List<Asignatura> asig){
        if (!titulo.isEstado()){

            titulo.setEstado(false);

        for (int i = 0; i < cursos.size(); i++) {
            if(cursos.get(i).getTitulo()==titulo){
                titulo.getCurso().get(i).setEstado(false);

            }
        }
        for (int j = 0; j < asig.size(); j++) {
                if (!asig.get(j).getCurso().getEstado()){
                    asig.get(j).setEstado(false);
                }




        }

        }
    }
}
