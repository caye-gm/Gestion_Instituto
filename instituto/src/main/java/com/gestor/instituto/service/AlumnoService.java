package com.gestor.instituto.service;

import com.gestor.instituto.models.Alumno;
import com.gestor.instituto.models.Usuario;
import com.gestor.instituto.repository.AlumnoRepository;
import com.gestor.instituto.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService extends BaseService<Alumno, Long, AlumnoRepository> {

    public AlumnoService(AlumnoRepository repo) {
        super(repo);
    }


    ///metodo
    @Autowired
    UsuarioService uS;
    @Autowired
    EnvioEmail eE;

    public void nuevoAlumno(Usuario usu){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String pass;
        pass=uS.generateRandomString(8);
        usu.setValidacion(pass);
        usu.setPassword(encoder.encode(uS.generateRandomString(8)));
        uS.save(usu);
        eE.sendEmail(usu, "Clave de acceso", "Clave cambio de contraseña: " + usu.getValidacion() + " ");
    }


}
