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


    public void tituloFalse(Titulo titulo,List<Curso> listaCursos,List<Alumno> listaAlumnos,List<Asignatura> listaAsig){
        if (!titulo.isEstado()){

        for (int i = 0; i < listaCursos.size(); i++) {
            listaCursos.get(i).setEstado(false);

            for (int j = 0; j < listaAlumnos.size(); j++) {

            }


        }

        }
    }
}
