package com.gestor.instituto.service;

import com.gestor.instituto.models.Profesor;
import com.gestor.instituto.models.Titulo;
import com.gestor.instituto.repository.ProfesorRepository;
import com.gestor.instituto.repository.TituloRepository;
import com.gestor.instituto.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class TituloService extends BaseService<Titulo,Long, TituloRepository> {
    public TituloService(TituloRepository repo) {
        super(repo);
    }
}
