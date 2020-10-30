package com.gestor.instituto.controllers;

import com.gestor.instituto.models.Usuario;
import com.gestor.instituto.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profesor")
public class ProfesorControllers {

    @Autowired
    UsuarioService usuarioS;
    @Autowired
    AlumnoService alumnoS;
    @Autowired
    AsignaturaService asignaturaS;
    @Autowired
    ProfesorService profesorS;
    @Autowired
    CursoService cursoS;
    @Autowired
    TituloService tituloS;
    @Autowired
    EnvioEmail eE;
    @Autowired
    HorarioService hH;

    @GetMapping("/")
    public String index() {
        return "/profesor/index";
    }
    //ALUMNOS
    @GetMapping("/alumnos")
    public String alumnos(Model m) {
        m.addAttribute("listaAlumnos", alumnoS.findAll());
        return "/profesor/alumnos";
    }

    //Titulos
    @GetMapping("/titulos")
    public String titulos(Model m) {
        m.addAttribute("listaTitulos", tituloS.findAll());

        return "/profesor/titulos";
    }
    //cursos
    @GetMapping("/cursos")
    public String cursos(@AuthenticationPrincipal Usuario uC, Model m) {
        m.addAttribute("usuario",uC.getEmail());
        m.addAttribute("listaCursos", cursoS.findAll());

        return "/profesor/cursos";
    }

    //horario

    @GetMapping("/horario/{id}")
    public String cursosAsigHorario(Model m, @PathVariable("id") long id, @AuthenticationPrincipal Usuario u) {
        m.addAttribute("horarios",hH.ordernarFinal(hH.horario(cursoS.findById(id))));
        m.addAttribute("usuario",u.getEmail());
        return "/profesor/horario";
    }
    //asignaturas del curso
    @GetMapping("/cursosAsignaturas/{id}")
    public String cursosAsig(Model m,@PathVariable("id") long id) {
        m.addAttribute("listaAsignaturas", cursoS.findById(id).getAsignaturas());

        return "/profesor/alumnos_asignaturas";
    }
    //alumnos de un curso
    @GetMapping("/cursosAsignaturas/alumno/{id}")
    public String cursosAsigAlum(Model m,@PathVariable("id") long id) {
        m.addAttribute("listaAlumnos", cursoS.findById(id).getAlumnos());

        return "/profesor/curso_listaAlumno";
    }

}
