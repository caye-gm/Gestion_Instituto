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
    public void cursoFalse(Curso curso){
        if (curso.getEstado()==false){

            curso.getTitulo().setEstado(false);
            curso.getTitulo().removeCurso(curso);

            for (int i = 0; i < curso.getAlumnos().size() ; i++) {
                Alumno a=curso.getAlumnos().get(i);
                a.setCurso(null);
                curso.removeAlumno(a);
                alumnoService.edit(a);
                cursoService.edit(curso);
            }
            for (int i = 0; i < curso.getAsignaturas().size() ; i++) {
                Long asig=curso.getAsignaturas().get(i).getId();
                asignaturaService.findById(asig).setCurso(null);
                curso.removeAsignatura(asignaturaService.findById(asig));
                asignaturaService.edit(asignaturaService.findById(asig));
                cursoService.edit(curso);
            }




        }
    }

}
