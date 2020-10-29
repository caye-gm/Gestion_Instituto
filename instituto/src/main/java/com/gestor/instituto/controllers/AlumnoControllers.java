package com.gestor.instituto.controllers;

import com.gestor.instituto.models.*;
import com.gestor.instituto.service.*;
import com.gestor.instituto.upload.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
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
    @Autowired
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
    public String convalidarAsignaturaSubmit (@ModelAttribute("convalidacion") SituacionExepcionalCommandObject SituacionExepcionalCommandObject, @AuthenticationPrincipal Alumno alumno, @RequestParam("file") MultipartFile file) {

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
    //Exencion
    @GetMapping("/exencion")
    public String exencionAsignatura (Model model, @AuthenticationPrincipal Alumno alumno) {
        model.addAttribute("exencion", new SituacionExepcionalCommandObject());
        model.addAttribute("listaAsignaturas", alumnoS.findById(alumno.getId()).getCurso().getAsignaturas());

        return "alumno/exencion";
    }
    @PostMapping("/exencion/submit")
    public String exencionAsignaturaSubmit (@ModelAttribute("exencion") SituacionExepcionalCommandObject SituacionExepcionalCommandObject, @AuthenticationPrincipal Alumno alumno, @RequestParam("file") MultipartFile file) {

        Asignatura asignatura = asignaturaService.findById(SituacionExepcionalCommandObject.getIdAsignatura());

        if (!file.isEmpty()) {

            String adjunto = storageService.store(file, alumno.getApellidos() + alumno.getNombre() + "-" + asignatura.getNombreAsig());

            SituacionExepcional excepcional = new SituacionExepcional();
            excepcional.setAdjunto(MvcUriComponentsBuilder.fromMethodName(AlumnoControllers.class, "serveFile", adjunto).build().toUriString());
            excepcional.setAdjunto(adjunto);
            excepcional.setAsignatura(asignatura);
            excepcional.setAlumno(alumno);
            excepcional.setFecha_resolucion(LocalDate.now());
            excepcional.setTipo("exención");
            excepcional.setEstado("Pendiente");
            situacionExepcionalService.save(excepcional);
        }

        return "redirect:/alumno/";
    }

    @GetMapping("/extincion")
    public String extincion() {
        return "/alumno/extincion";
    }

/*
    @PostMapping("/convalidacion/submit")
    public String asignaturasSubmit(@AuthenticationPrincipal Alumno a, @RequestParam("pdf") MultipartFile multipartFile, Model model, SituacionExepcional situacionExcepcional){

        if(!multipartFile.isEmpty()) {
            situacionExcepcional.setAlumno(a);
            String pdf = storageService.store(multipartFile, situacionExcepcional.getAlumno().getId());
            situacionExcepcional.setAdjunto(MvcUriComponentsBuilder
                    .fromMethodName(AlumnoControllers.class, "serverFile", "solicitud").build().toUriString());
            situacionExcepcional.setAdjunto(pdf);
            situacionExcepcional.setFecha_solicitud(LocalDate.now());
            situacionExcepcional.setFecha_resolucion(null);
            situacionExcepcional.setEstado("Pendiente");
            System.out.println(situacionExcepcional.getAsignatura());
            situacionExepcionalService.save(situacionExcepcional);
            return "redirect:/alumno/index";
        }else{
            return "/alumno/index";
        }
    }
*/
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().body(file);
    }

}
