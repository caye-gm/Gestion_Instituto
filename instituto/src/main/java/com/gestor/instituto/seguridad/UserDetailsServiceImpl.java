package com.gestor.instituto.seguridad;

import com.gestor.instituto.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


        @Service
        @RequiredArgsConstructor
        public class UserDetailsServiceImpl implements UserDetailsService {


            private final UsuarioService usuarioServicio;

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return usuarioServicio.buscarPorEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
            }

        }

