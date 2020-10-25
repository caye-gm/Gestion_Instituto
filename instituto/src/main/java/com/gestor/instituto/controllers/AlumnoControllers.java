package com.gestor.instituto.controllers;

import com.gestor.instituto.models.Alumno;
import com.gestor.instituto.models.Horario;
import com.gestor.instituto.service.AlumnoService;
import com.gestor.instituto.service.CursoService;
import com.gestor.instituto.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/alumno")
public class AlumnoControllers {


    @Autowired
    HorarioService horarioService;
    @Autowired
    CursoService cursoService;
    @Autowired
    AlumnoService alumnoService;

    @GetMapping("/")
    public String index() {
        return "/alumno/index";
    }
    @GetMapping("/horario")
    public String horario(@AuthenticationPrincipal Alumno alumno, Model m) {
        m.addAttribute("usuario",alumno.getEmail());
        //m.addAttribute("horarios",horarioService.ordernarFinal(alumno.getCurso()));
        return "/alumno/horario";
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
