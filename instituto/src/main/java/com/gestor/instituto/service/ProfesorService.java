package com.gestor.instituto.service;


import com.gestor.instituto.models.Alumno;
import com.gestor.instituto.models.Profesor;
import com.gestor.instituto.models.Usuario;
import com.gestor.instituto.repository.ProfesorRepository;
import com.gestor.instituto.service.base.BaseService;
import com.gestor.instituto.upload.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService extends BaseService<Profesor,Long,ProfesorRepository> {


    public ProfesorService(ProfesorRepository repo) {
        super(repo);
    }



    //Crear Alumno

    @Autowired
    UsuarioService uS;
    @Autowired
    EnvioEmail eE;



    public void nuevoProfesor(Profesor profesor){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String pass;
        pass=uS.generateRandomString(8);
        profesor.setValidacion(pass);
        profesor.setPassword(encoder.encode(uS.generateRandomString(8)));
        uS.save(profesor);
        eE.sendEmail(profesor, "Clave de acceso", "Clave cambio de contraseña: " + profesor.getValidacion() + " ");
    }
    


    public void convalidar(){

    }
}
