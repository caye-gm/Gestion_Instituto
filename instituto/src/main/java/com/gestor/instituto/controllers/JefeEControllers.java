package com.gestor.instituto.controllers;

import com.gestor.instituto.models.*;
import com.gestor.instituto.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jefe_de_estudio")
public class JefeEControllers {

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
        public String index(@AuthenticationPrincipal Usuario u,Model m) {
                m.addAttribute("usuario",u.getEmail());
                return "/jefe_de_estudio/index";
        }


        //ALUMNOS
        @GetMapping("/alumnos")
        public String alumnos(Model m) {
                m.addAttribute("listaAlumnos", alumnoS.findAll());
                return "/jefe_de_estudio/alumnos";
        }

        @GetMapping("/alumnoRegistro")
        public String alumnoRegistro(Model m ) {
                m.addAttribute("listaCursos", cursoS.findAll());
                m.addAttribute("alumnoRegistro",new Alumno());
                return "/jefe_de_estudio/alumnoRegistro";
        }
        @PostMapping("/alumnoRegistro/submit")
        public String alumnoRegistroSubmit(@ModelAttribute("alumnoRegistro") Alumno usu) {
                alumnoS.nuevoAlumno(usu);
                return "redirect:/jefe_de_estudio/alumnoRegistro";


        }
        @GetMapping("/alumnoEdit/{id}")
        public String alumnoEdit(@PathVariable("id") long id,Model m) {
                m.addAttribute("listaCursos", cursoS.findAll());
                m.addAttribute("alumnoRegistro", alumnoS.findById(id));
                return "/jefe_de_estudio/alumnoRegistro";
        }

        @PostMapping("/alumnoEdit/submit")
        public String alumnoEditsubmit(@ModelAttribute("alumnoRegistro") Alumno a1) {
                alumnoS.edit(a1);
                return "redirect:/jefe_de_estudio/alumnos";
        }


        //DOCENTES
        @GetMapping("/docentes")
        public String docentes(Model m) {
                m.addAttribute("listaDocentes", profesorS.findAll());
                return "/jefe_de_estudio/docentes";
        }

        @GetMapping("/docenteRegistro")
        public String docenteRegistro(Model m) {
                m.addAttribute("docenteRegistro",new Profesor());
                return "/jefe_de_estudio/docenteRegistro";
        }
        
        @PostMapping("/docenteRegistro/submit")
        public String docenteRegistroSubmit(@ModelAttribute("docenteRegistro") Profesor prof) {
                profesorS.nuevoProfesor(prof);
                return "redirect:/jefe_de_estudio/docenteRegistro";
        }
        @GetMapping("/docenteEdit/{id}")
        public String docenteEdit(@PathVariable("id") long id,Model m) {

                m.addAttribute("docenteRegistro", profesorS.findById(id));
                return "/jefe_de_estudio/docenteRegistro";
        }

        @PostMapping("/docenteEdit/submit")
        public String docenteEditsubmit(@ModelAttribute("docenteRegistro") Profesor p1) {
                profesorS.edit(p1);
                return "redirect:/jefe_de_estudio/docentes";
        }


        //CURSO
        @GetMapping("/cursos")
        public String cursos(@AuthenticationPrincipal Usuario uC,Model m) {
                m.addAttribute("usuario",uC.getEmail());
                m.addAttribute("listaCursos", cursoS.findAll());

                return "/jefe_de_estudio/cursos";
        }
        @GetMapping("/cursoEdit/{id}")
        public String cursosEdit(@PathVariable("id") long id,Model m) {

                m.addAttribute("listaTitulos", tituloS.findAll());
                m.addAttribute("cursoEdit", cursoS.findById(id));

                return "/jefe_de_estudio/cursoEditar";
        }

        @PostMapping("/cursoEdit/submit")
        public String cursoEditsubmit(@ModelAttribute("cursoEdit") Curso curso) {
                cursoS.edit(curso);

                return "redirect:/jefe_de_estudio/cursos";
        }






        //C.ASG
        @GetMapping("/cursosAsignaturas/{id}")
        public String cursosAsig(Model m,@PathVariable("id") long id) {
                m.addAttribute("listaAsignaturas", cursoS.findById(id).getAsignaturas());

                return "/jefe_de_estudio/alumnos_asignaturas";
        }
        @GetMapping("/cursoAsignaturaEdit/{id}")
        public String cursoAsignaturaEdit(@PathVariable("id") long id,Model m) {
                m.addAttribute("horario",asignaturaS.findById(id).getHorario());
                m.addAttribute("sExepcional",asignaturaS.findById(id).getSituacionExepcional());
                m.addAttribute("sAmpliacion",asignaturaS.findById(id).getSolicitudAmpliacionMatricula());
                m.addAttribute("listaCursos", cursoS.findAll());
                m.addAttribute("listaHorarios", hH.findAll());
                m.addAttribute("listaAsignaturas", alumnoS.findAll());
                m.addAttribute("asignaturaEdit", asignaturaS.findById(id));

                return "/jefe_de_estudio/asignaturaEditar";
        }
        @PostMapping("/cursoAsignaturaEdit/submit")
        public String AsignaturaEditsubmit(@ModelAttribute("asignaturaEdit") Asignatura asignatura,Model m) {
                m.addAttribute("horario",asignatura.getHorario());
                m.addAttribute("sExepcional",asignatura.getSituacionExepcional());
                m.addAttribute("sAmpliacion",asignatura.getSolicitudAmpliacionMatricula());
                m.addAttribute("listaCursos", cursoS.findAll());
                asignaturaS.edit(asignatura);

                return "redirect:/jefe_de_estudio/cursos";
        }


        //C.ALUM
        @GetMapping("/cursosAsignaturasAlumnos")
        public String cursosAsigAlum() {
                return "/jefe_de_estudio/alumnos_asignaturas";
        }

        @GetMapping("/convalidacion")
        public String convalidacion() {
                return "/jefe_de_estudio/convalidacion";
        }
        @GetMapping("/extincion")
        public String extincion() {
                return "/jefe_de_estudio/extincion";
        }

        //TITULOS

        @GetMapping("/titulos")
        public String titulos(Model m) {
                m.addAttribute("listaTitulos", tituloS.findAll());

                return "/jefe_de_estudio/titulos";
        }


        @GetMapping("/tituloEdit/{id}")
        public String tituloEdit(@PathVariable("id") long id,Model m) {

                m.addAttribute("listaTitulos", tituloS.findAll());
                m.addAttribute("tituloEdit", tituloS.findById(id));

                return "/jefe_de_estudio/tituloEditar";
        }

        @PostMapping("/tituloEdit/submit")
        public String tituloEditsubmit(@ModelAttribute("tituloEdit") Titulo titulo) {


                tituloS.edit(titulo);

                return "redirect:/jefe_de_estudio/titulos";
        }
        //HORARIO

        @GetMapping("/horario")
        public String horario(@AuthenticationPrincipal Usuario u,Model m) {
                m.addAttribute("usuario",u.getEmail());
                //m.addAttribute("horario",hH.)

                return "/jefe_de_estudio/horario";
        }





}
