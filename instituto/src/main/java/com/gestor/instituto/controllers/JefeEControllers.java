package com.gestor.instituto.controllers;

import com.gestor.instituto.models.*;
import com.gestor.instituto.service.*;
import com.gestor.instituto.upload.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
                alumnoS.estadoFalse(usu);
                if(usu.isAccountNonLocked()){
                        alumnoS.nuevoAlumno(usu);
                }
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
                alumnoS.estadoFalse(a1);
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

        @GetMapping("/cursoCrear")
        public String cursosAdd(Model m) {

                m.addAttribute("listaTitulos", tituloS.findAll());
                m.addAttribute("cursoEdit", new Curso());

                return "/jefe_de_estudio/cursoEditar";
        }
        @PostMapping("/cursoCrear/submit")
        public String cursosAddSubmit(@ModelAttribute("cursoEdit") Curso curso,Model m) {

                cursoS.save(curso);
                return "/jefe_de_estudio/cursoEditar";
        }
        @GetMapping("/cursoEdit/{id}")
        public String cursosEdit(@PathVariable("id") long id,Model m) {

                m.addAttribute("listaTitulos", tituloS.findAll());
                m.addAttribute("cursoEdit", cursoS.findById(id));




                return "/jefe_de_estudio/cursoEditar";
        }

        @PostMapping("/cursoEdit/submit")
        public String cursoEditsubmit(@ModelAttribute("cursoEdit") Curso curso) {

                cursoS.cursoFalse(curso,cursoS.findById(curso.getId()).getAlumnos(),cursoS.findById(curso.getId()).getAsignaturas());




                cursoS.edit(curso);

                return "redirect:/jefe_de_estudio/cursos";
        }






        //C.ASG



        @GetMapping("/cursosAsignaturas/{id}")
        public String cursosAsig(Model m,@PathVariable("id") long id) {
                m.addAttribute("listaAsignaturas", cursoS.findById(id).getAsignaturas());

                return "/jefe_de_estudio/alumnos_asignaturas";
        }

        //---
        @GetMapping("/cursoAsignaturaCrear")
        public String cursoAsignaturaCrear(Model m) {
                m.addAttribute("listaCursos", cursoS.findAll());
                m.addAttribute("asignaturaEdit", new Asignatura());

                return "/jefe_de_estudio/asignaturaEditar";
        }
        @PostMapping("/cursoAsignaturaCrear/submit")
        public String AsignaturaAddSubmit(@ModelAttribute("asignaturaEdit") Asignatura asignatura,Model m) {

                m.addAttribute("listaCursos", cursoS.findAll());
                asignaturaS.save(asignatura);

                return "redirect:/jefe_de_estudio/cursos";
        }


        //---



        @GetMapping("/cursoAsignaturaEdit/{id}")
        public String cursoAsignaturaEdit(@PathVariable("id") long id,Model m) {
                m.addAttribute("listaCursos", cursoS.findAll());
                m.addAttribute("asignaturaEdit", asignaturaS.findById(id));

                return "/jefe_de_estudio/asignaturaEditar";
        }
        @PostMapping("/cursoAsignaturaEdit/submit")
        public String AsignaturaEditsubmit(@ModelAttribute("asignaturaEdit") Asignatura asignatura,Model m) {

                m.addAttribute("listaCursos", cursoS.findAll());
                asignaturaS.edit(asignatura);

                return "redirect:/jefe_de_estudio/cursos";
        }

        //alumno de un curso

        @GetMapping("/cursosAsignaturas/alumno/{id}")
        public String cursosAsigAlum(Model m,@PathVariable("id") long id) {
                m.addAttribute("listaAlumnos", cursoS.findById(id).getAlumnos());

                return "/jefe_de_estudio/curso_listaAlumno";
        }






        //horario


        @GetMapping("/cursosAsignaturas/horario/{id}")
        public String cursosAsigHorario(Model m,@PathVariable("id") long id,@AuthenticationPrincipal Usuario u) {
                m.addAttribute("horarios",hH.ordernarFinal(hH.horario(cursoS.findById(id))));
                m.addAttribute("usuario",u.getEmail());
                return "/jefe_de_estudio/horario";
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
        @GetMapping("/tituloCrear")
        public String tituloAdd(Model m) {

                m.addAttribute("listaTitulos", tituloS.findAll());
                m.addAttribute("tituloEdit", new Curso());

                return "/jefe_de_estudio/tituloEditar";
        }

        @PostMapping("/tituloCrear/submit")
        public String tituloCrearsubmit(@ModelAttribute("tituloEdit") Titulo titulo) {


                tituloS.save(titulo);

                return "redirect:/jefe_de_estudio/titulos";
        }


        @GetMapping("/tituloEdit/{id}")
        public String tituloEdit(@PathVariable("id") long id,Model m) {

                m.addAttribute("listaTitulos", tituloS.findAll());
                m.addAttribute("tituloEdit", tituloS.findById(id));

                return "/jefe_de_estudio/tituloEditar";
        }



        @PostMapping("/tituloEdit/submit")
        public String tituloEditsubmit(@ModelAttribute("tituloEdit") Titulo titulo) {

                //tituloS.tituloFalse(titulo);
                tituloS.edit(titulo);

                return "redirect:/jefe_de_estudio/titulos";
        }






}
