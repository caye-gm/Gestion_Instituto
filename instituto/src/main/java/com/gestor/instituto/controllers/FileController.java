package com.gestor.instituto.controllers;

import com.gestor.instituto.service.FileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping("/jefe_de_estudio/subirCSV")
    public String index() {
        return "/jefe_de_estudio/subirCSV";
    }

    @PostMapping("/jefe_de_estudio/subirCSV")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        fileService.uploadFile(file);

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "/jefe_de_estudio/subirCSV";
    }

/*
    @GetMapping("/descargar/{nombre}")
    public ResponseEntity<Resource> descargar(@PathVariable("nombre") String nombre){
        Resource resource = FileSystemStorageService.loadAsResource(nombre);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=""+resource.getFilename()+""").body(resource);
    }*/
}
