package com.gestor.instituto.service;

import com.gestor.instituto.models.Profesor;
import com.gestor.instituto.models.SituacionExep;
import com.gestor.instituto.models.SituacionExepcional;
import com.gestor.instituto.repository.ProfesorRepository;
import com.gestor.instituto.repository.SituacionExepcionalRepository;
import com.gestor.instituto.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class SituacionExepcionalService extends BaseService<SituacionExepcional, SituacionExep, SituacionExepcionalRepository> {

    public SituacionExepcionalService(SituacionExepcionalRepository repo) {
        super(repo);
    }
}




