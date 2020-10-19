package com.gestor.instituto.controllers;

import com.gestor.instituto.models.Usuario;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jefe_de_estudio")
public class JefeEControllers {

        @GetMapping("/")
        public String index() {
            return "/jefe_de_estudio/index";
        }

        @GetMapping("/alumnos")
        public String alumnos() {
        return "/jefe_de_estudio/alumnos";
        }

        @GetMapping("/alumnoRegistro")
        public String alumnoRegistro() {
                return "/jefe_de_estudio/alumnoRegistro";
        }
        @GetMapping("/docentes")
        public String docentes() {
                return "/jefe_de_estudio/docentes";
        }

        @GetMapping("/docenteRegistro")
        public String docenteRegistro() {
                return "/jefe_de_estudio/docenteRegistro";
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
