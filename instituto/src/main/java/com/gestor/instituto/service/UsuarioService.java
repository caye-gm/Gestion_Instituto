package com.gestor.instituto.service;

import com.gestor.instituto.models.Usuario;
import com.gestor.instituto.repository.UsuarioRepository;
import com.gestor.instituto.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.Random;

@Service
public class UsuarioService extends BaseService<Usuario, Long, UsuarioRepository> {


    public UsuarioService(UsuarioRepository repo) {
        super(repo);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return repositorio.findFirstByEmail(email);
        }



        //metodos

        public String generateRandomString(int length) {
        String asciiUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String asciiLowerCase = asciiUpperCase.toLowerCase();
        String digits = "1234567890";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Random rand = new Random();
        while (i < length) {
            sb.append(asciiLowerCase.charAt(rand.nextInt(digits.length())));
            i++;
        }
        return sb.toString();
    }



}
