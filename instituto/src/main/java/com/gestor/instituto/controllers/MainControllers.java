package com.gestor.instituto.controllers;

import com.gestor.instituto.models.Usuario;
import com.gestor.instituto.service.EnvioEmail;
import com.gestor.instituto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainControllers {



    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/registro")
    public String registro() {
        return "/registro/registro";
    }
    @PostMapping("/registro/submit")
    public String registroSubmit() {
        return "/registro/registro";
    }


    @GetMapping("/acceso-denegado")
    public String accessoDenegado() {
        return "401";
    }


}
