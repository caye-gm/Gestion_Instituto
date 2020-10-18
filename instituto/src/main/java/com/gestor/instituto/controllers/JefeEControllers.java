package com.gestor.instituto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        @GetMapping("/curso")
        public String curso() {
                return "/jefe_de_estudio/curso";
        }

}
