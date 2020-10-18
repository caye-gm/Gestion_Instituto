package com.gestor.instituto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profesor")
public class ProfesorControllers {

    @GetMapping("/")
    public String index() {

        return "/profesor/index";
    }


}
