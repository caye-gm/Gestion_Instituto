package com.gestor.instituto.service;


import com.gestor.instituto.models.Asignatura;
import com.gestor.instituto.repository.AsignaturaRepository;
import com.gestor.instituto.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaService extends BaseService<Asignatura,Long,AsignaturaRepository> {
    public AsignaturaService(AsignaturaRepository repo) {
        super(repo);
    }
}

