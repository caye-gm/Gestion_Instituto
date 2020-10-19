package com.gestor.instituto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumno")
public class AlumnoControllers {

    @GetMapping("/")
    public String index() {
        return "/alumno/index";
    }

    @GetMapping("/convalidacion")
    public String covalidacion() {
        return "/alumno/convalidacion";
    }

    @GetMapping("/extincion")
    public String extincion() {
        return "/alumno/extincion";
    }


}
