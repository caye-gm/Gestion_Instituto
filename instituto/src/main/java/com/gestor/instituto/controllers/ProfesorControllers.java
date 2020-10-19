package com.gestor.instituto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profesor")
public class ProfesorControllers {



    @GetMapping("/")
    public String index() {
        return "/profesor/index";
    }
    @GetMapping("/alumnos")
    public String alumnos() {
        return "/profesor/alumnos";
    }
    @GetMapping("/cursos")
    public String cursos() {
        return "/profesor/cursos";
    }
    @GetMapping("/titulos")
    public String titulos() {
        return "/profesor/titulos";
    }


}
