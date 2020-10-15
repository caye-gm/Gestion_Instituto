package com.gestor.instituto.service;


import com.gestor.instituto.models.Profesor;
import com.gestor.instituto.repository.ProfesorRepository;
import com.gestor.instituto.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService extends BaseService<Profesor,Long,ProfesorRepository> {


    public ProfesorService(ProfesorRepository repo) {
        super(repo);
    }
}
