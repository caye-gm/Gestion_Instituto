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
    @Autowired
    HorarioService horarioService;

    public void tituloFalse(Titulo titulo){

       /* for (int i = 0; i < titulo.getCurso().size(); i++) {
            if(titulo.getCurso().get(i).getTitulo()==titulo){
                titulo.getCurso().get(i).setEstado(false);

            }
        }*/
            for (Curso curso:
                 titulo.getCurso()) {
                for (Asignatura asig:
                     curso.getAsignaturas()) {
                    for (Horario hora:
                         asig.getHorario()) {
                        hora.setEsAlta(false);
                        horarioService.edit(hora);
                    }
                    asig.setEstado(false);
                    asignaturaService.edit(asig);
                }
                curso.setEstado(false);
                cursoService.edit(curso);
            }
            titulo.setEstado(false);
            tituloService.edit(titulo);





        }


    }

