package com.gestor.instituto;

import com.gestor.instituto.models.Alumno;
import com.gestor.instituto.models.Profesor;
import com.gestor.instituto.service.AlumnoService;
import com.gestor.instituto.service.EnvioEmail;
import com.gestor.instituto.service.ProfesorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class InstitutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstitutoApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(EnvioEmail eE,ProfesorService ProfS, AlumnoService AlumS, PasswordEncoder passwordEncoder) {
		return args -> {

			Alumno a1=new Alumno(3, "cayetanog2000@gmail.com", passwordEncoder.encode("1234"), "Cayetano", "García Martín", "4900000000Z", "+34 684213930", LocalDate.now(),"23","baja");

			AlumS.save(a1);

			Profesor p1=new Profesor(2,"luismi@gmail.com",passwordEncoder.encode("1234"),"Luismi","Lopez","4200000000Z","+34 955213930",LocalDate.now(),"fsd","Alta",false);
			Profesor p2=new Profesor(1,"angel@gmail.com",passwordEncoder.encode("1234"),"Angel","Lopez","4100000000Z","+34 955213930",LocalDate.now(),"fds","Alta",true);

			ProfS.save(p1);
			ProfS.save(p2);

			//eE.sendEmail(a1,"prueba","esto es una prueba para developers");
		};


	}}
