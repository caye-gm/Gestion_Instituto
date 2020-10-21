package com.gestor.instituto;

import com.gestor.instituto.models.*;
import com.gestor.instituto.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class InstitutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstitutoApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(EnvioEmail eE,ProfesorService ProfS,CursoService CursoService, AlumnoService AlumS,TituloService TituloService,AsignaturaService AsignaturaService, PasswordEncoder passwordEncoder) {
		return args -> {

			Alumno a1=new Alumno(3, "cayetanog2000@gmail.com", passwordEncoder.encode("1234"), "Cayetano", "García Martín", "4900000000Z", "684213930", LocalDate.now(),"2sadsadd3",true);

			AlumS.save(a1);

			Profesor p1=new Profesor(2,"luismi@gmail.com",passwordEncoder.encode("1234"),"Luismi","Lopez","4200000000Z","955213930",LocalDate.now(),"fsd",true,false);
			Profesor p2=new Profesor(1,"angel@gmail.com",passwordEncoder.encode("1234"),"Angel","Lopez","4100000000Z","955213930",LocalDate.now(),"fds",true,true);

			ProfS.save(p1);
			ProfS.save(p2);



			List<Curso> curso = new ArrayList<>();
			Titulo t1=new Titulo("Desarrollo de aplicaciones multiplataformas",true,curso);

			List<SituacionExepcional> situacionExepcional = new ArrayList<>();
			List<SolicitudAmpliacionMatricula> solicitudAmpliacionMatricula = new ArrayList<>();
			Asignatura asg1=new Asignatura("base de datos",true,situacionExepcional,solicitudAmpliacionMatricula);



			Curso c1 = new Curso(1,"Desarrollo de aplicaciones multiplataformas","2020",true,t1);


			TituloService.save(t1);
			AsignaturaService.save(asg1);
			CursoService.save(c1);


			//eE.sendEmail(a1,"prueba","esto es una prueba para developers");
		};


	}}
