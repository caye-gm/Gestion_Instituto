package com.gestor.instituto.controllers;

import com.gestor.instituto.models.*;
import com.gestor.instituto.service.*;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jefe_de_estudio")
public class JefeEControllers {

        @Autowired
        UsuarioService uS;
        @Autowired
        AlumnoService aS;
        @Autowired
        ProfesorService pS;
        @Autowired
        CursoService cS;
        @Autowired
        TituloService tS;
        @Autowired
        EnvioEmail eE;





        @GetMapping("/")
        public String index(@AuthenticationPrincipal Usuario u,Model m) {
                m.addAttribute("usuario",u.getEmail());
                return "/jefe_de_estudio/index";
        }


        @GetMapping("/alumnos")
        public String alumnos(Model m) {
                m.addAttribute("listaAlumnos", aS.findAll());
                return "/jefe_de_estudio/alumnos";
        }

        @GetMapping("/alumnoRegistro")
        public String alumnoRegistro(Model m ) {
                m.addAttribute("listaCursos", cS.findAll());
                m.addAttribute("alumnoRegistro",new Alumno());
                return "/jefe_de_estudio/alumnoRegistro";
        }
        @PostMapping("/alumnoRegistro/submit")
        public String alumnoRegistroSubmit(@ModelAttribute("alumnoRegistro") Alumno usu) {
                pS.nuevoAlumno(usu);
                return "redirect:/jefe_de_estudio/alumnoRegistro";


        }
        @GetMapping("/alumnoEdit{id}")
        public String alumnoEdit(@PathVariable("id") long id,Model m) {
                m.addAttribute("listaCursos", cS.findAll());
                m.addAttribute("alumnoEdit",aS.findById(id));
                return "/jefe_de_estudio/alumnoEditar";
        }

        @PostMapping("/alumnoEdit/submit")
        public String alumnoEditsubmit(@ModelAttribute("alumnoEdit") Alumno a1) {

                aS.edit(a1);
                return "redirect:/jefe_de_estudio/alumnos";
        }









        @GetMapping("/docentes")
        public String docentes(Model m) {
                m.addAttribute("listaDocentes", pS.findAll());
                return "/jefe_de_estudio/docentes";
        }

        @GetMapping("/docenteRegistro")
        public String docenteRegistro(Model m) {
                m.addAttribute("docenteRegistro",new Profesor());
                return "/jefe_de_estudio/docenteRegistro";
        }
        
        @PostMapping("/docenteRegistro/submit")
        public String docenteRegistroSubmit(@ModelAttribute("docenteRegistro") Profesor prof) {
                pS.nuevoProfesor(prof);
                return "redirect:/jefe_de_estudio/docenteRegistro";
        }




        @GetMapping("/cursos")
        public String cursos(@AuthenticationPrincipal Usuario uC,Model m) {
                m.addAttribute("usuario",uC.getEmail());
                m.addAttribute("listaCursos", cS.findAll());
                return "/jefe_de_estudio/cursos";
        }

        @GetMapping("/cursosAsignaturas")
        public String cursosAsig() {
                return "/jefe_de_estudio/asignaturas";
        }

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


        @GetMapping("/titulos")
        public String titulos(@AuthenticationPrincipal Usuario u,Model m) {
                m.addAttribute("usuario",u.getEmail());
                m.addAttribute("listaTitulos", tS.findAll());


                return "/jefe_de_estudio/titulos";
        }


        @GetMapping("/titulosEdit{id}")
        public String tituloEdit(@PathVariable("id") long id,Model m) {
                m.addAttribute("listaTitulos", tS.findAll());
                m.addAttribute("tituloEdit",tS.findById(id));
                return "/jefe_de_estudio/tituloEditar";
        }

        @PostMapping("/tituloEdit/submit")
        public String tituloEditsubmit(@ModelAttribute("tituloEdit") Titulo titulo) {
                tS.edit(titulo);

                return "redirect:/jefe_de_estudio/titulos";
        }





}
