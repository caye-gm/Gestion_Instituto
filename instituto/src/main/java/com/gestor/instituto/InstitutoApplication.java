package com.gestor.instituto;

import com.gestor.instituto.models.Alumno;
import com.gestor.instituto.models.Profesor;
import com.gestor.instituto.service.AlumnoService;
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
	public CommandLineRunner init(ProfesorService ProfS, AlumnoService AlumS, PasswordEncoder passwordEncoder) {
		return args -> {

			Alumno a1=new Alumno(1, "cayetanog2000@gmail.com", passwordEncoder.encode("1234"), "Cayetano", "García Martín", "4900000000Z", "+34 684213930", LocalDate.now());

			AlumS.save(a1);


		};


	}}
