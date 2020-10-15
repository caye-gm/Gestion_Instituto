package com.gestor.instituto.service;

import com.gestor.instituto.models.Alumno;
import com.gestor.instituto.repository.AlumnoRepository;
import com.gestor.instituto.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService extends BaseService<Alumno, Long, AlumnoRepository> {

    public AlumnoService(AlumnoRepository repo) {
        super(repo);
    }
}
