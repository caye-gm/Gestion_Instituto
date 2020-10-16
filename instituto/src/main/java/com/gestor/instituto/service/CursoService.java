package com.gestor.instituto.service;

import com.gestor.instituto.models.Curso;
import com.gestor.instituto.models.Profesor;
import com.gestor.instituto.repository.CursoRepository;
import com.gestor.instituto.repository.ProfesorRepository;
import com.gestor.instituto.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CursoService extends BaseService<Curso,Long, CursoRepository> {
    public CursoService(CursoRepository repo) {
        super(repo);
    }
}
