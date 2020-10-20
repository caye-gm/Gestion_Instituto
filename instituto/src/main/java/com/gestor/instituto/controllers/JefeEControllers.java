package com.gestor.instituto.controllers;

import com.gestor.instituto.models.Alumno;
import com.gestor.instituto.models.Profesor;
import com.gestor.instituto.models.Usuario;
import com.gestor.instituto.service.AlumnoService;
import com.gestor.instituto.service.EnvioEmail;
import com.gestor.instituto.service.ProfesorService;
import com.gestor.instituto.service.UsuarioService;
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
        EnvioEmail eE;




        @GetMapping("/")
        public String index() {
            return "/jefe_de_estudio/index";
        }


        @GetMapping("/alumnos")
        public String alumnos(Model m) {
                m.addAttribute("listaAlumnos", aS.findAll());
                return "/jefe_de_estudio/alumnos";
        }

        @GetMapping("/alumnoRegistro")
        public String alumnoRegistro(Model m ) {
                m.addAttribute("alumnoRegistro",new Alumno());
                return "/jefe_de_estudio/alumnoRegistro";
        }
        @PostMapping("/alumnoRegistro/submit")
        public String alumnoRegistroSubmit(@ModelAttribute("alumnoRegistro") Alumno usu) {
                pS.nuevoAlumno(usu);
                return "redirect:/jefe_de_estudio/alumnoRegistro";
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
        public String cursos() {
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
        public String titulos() {
                return "/jefe_de_estudio/titulos";
        }



}
