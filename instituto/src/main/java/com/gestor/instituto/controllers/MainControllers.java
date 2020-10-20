package com.gestor.instituto.controllers;

import com.gestor.instituto.models.RegistroCommandObject;
import com.gestor.instituto.models.Usuario;
import com.gestor.instituto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class MainControllers {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/registro")
    public String registro(Model m) {
        m.addAttribute("usuarioValidacion",new RegistroCommandObject());

        return "/registro/registro";
    }

    @PostMapping("/registro/submit")
    public String registroSubmit(@ModelAttribute("usuarioValidacion") RegistroCommandObject ro) {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String email,password,validacion;
        email=ro.getEmail();
        password=ro.getPass();
        validacion=ro.getValidacion();

        Optional<Usuario> u1;
        u1=usuarioService.buscarPorEmail(email);
        Usuario usuario=usuarioService.findById(u1.get().getId());

        if (usuario.getValidacion().equalsIgnoreCase(validacion)){
            usuario.setPassword(encoder.encode(password));
            usuarioService.edit(usuario);
        }
        return "redirect:/login";
    }


    @GetMapping("/acceso-denegado")
    public String accessoDenegado() {
        return "401";
    }


}
