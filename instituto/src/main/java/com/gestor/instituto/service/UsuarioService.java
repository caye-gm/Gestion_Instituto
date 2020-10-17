package com.gestor.instituto.service;

import com.gestor.instituto.models.Usuario;
import com.gestor.instituto.repository.UsuarioRepository;
import com.gestor.instituto.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService extends BaseService<Usuario, Long, UsuarioRepository> {


    public UsuarioService(UsuarioRepository repo) {
        super(repo);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return repositorio.findFirstByEmail(email);
        }

}
