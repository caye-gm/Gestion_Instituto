package com.gestor.instituto.service;

import com.gestor.instituto.models.Alumno;
import com.gestor.instituto.models.Asignatura;
import com.gestor.instituto.models.Curso;
import com.gestor.instituto.models.Profesor;
import com.gestor.instituto.repository.CursoRepository;
import com.gestor.instituto.repository.ProfesorRepository;
import com.gestor.instituto.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService extends BaseService<Curso,Long, CursoRepository> {
    public CursoService(CursoRepository repo) {
        super(repo);
    }

    @Autowired
    AlumnoService alumnoService;
    @Autowired
    AsignaturaService asignaturaService;
    @Autowired
    CursoService cursoService;

    public void cursoFalse(Curso curso, List<Alumno> listaAlumnos,List<Asignatura> listaAsig){
        if (!curso.getEstado()){

            curso.getTitulo().setEstado(false);


            for (int i = 0; i < listaAlumnos.size(); i++) {

                listaAlumnos.get(i).setEstado(false);
                listaAlumnos.get(i).setCurso(null);

            }

            for (int i = 0; i < listaAsig.size(); i++) {
                listaAsig.get(i).setEstado(false);

            }
        }
    }




}
