package com.gestor.instituto.controllers;

import com.gestor.instituto.models.*;
import com.gestor.instituto.service.*;
import com.gestor.instituto.upload.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/alumno")
public class AlumnoControllers {


    @Autowired
    HorarioService horarioService;
    @Autowired
    CursoService cursoService;
    @Autowired
    AlumnoService alumnoS;
    @Autowired
    AsignaturaService asignaturaService;
    @Autowired
    SituacionExepcionalService situacionExepcionalService;

    StorageService storageService;


    @GetMapping("/")
    public String index() {
        return "/alumno/index";
    }
    @GetMapping("/horario")
    public String horario(@AuthenticationPrincipal Alumno alumno, Model m) {
        m.addAttribute("usuario",alumno.getEmail());
        m.addAttribute("horarios",horarioService.ordernarFinal(horarioService.horario(alumno.getCurso())));
        return "/alumno/horario";
    }



    //convalidacion
    @GetMapping("/convalidacion")
    public String convalidadAsignatura (Model model, @AuthenticationPrincipal Alumno alumno) {
        model.addAttribute("convalidacion", new SituacionExepcionalCommandObject());
        model.addAttribute("listaAsignaturas", alumnoS.findById(alumno.getId()).getCurso().getAsignaturas());

        return "alumno/convalidacion";
    }

    @PostMapping("/convalidacion/submit")
    public String convalidarAsignaturaSubmit (@ModelAttribute("convalidacionForm") SituacionExepcionalCommandObject SituacionExepcionalCommandObject, @AuthenticationPrincipal Alumno alumno, @RequestParam("file") MultipartFile file) {

        Asignatura asignatura = asignaturaService.findById(SituacionExepcionalCommandObject.getIdAsignatura());

        if (!file.isEmpty()) {

            String adjunto = storageService.store(file, alumno.getApellidos() + alumno.getNombre() + "-" + asignatura.getNombreAsig());

            SituacionExepcional excepcional = new SituacionExepcional();
            excepcional.setAdjunto(MvcUriComponentsBuilder.fromMethodName(AlumnoControllers.class, "serveFile", adjunto).build().toUriString());
            excepcional.setAdjunto(adjunto);
            excepcional.setAsignatura(asignatura);
            excepcional.setAlumno(alumno);
            excepcional.setFecha_resolucion(LocalDate.now());
            excepcional.setTipo("Convalidación");
            excepcional.setEstado("Pendiente");
            situacionExepcionalService.save(excepcional);
        }

        return "redirect:/alumno/";
    }



    @GetMapping("/extincion")
    public String extincion() {
        return "/alumno/extincion";
    }


}
