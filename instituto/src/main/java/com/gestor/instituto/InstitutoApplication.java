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
	public CommandLineRunner init(HorarioService hh,EnvioEmail eE,ProfesorService ProfS,CursoService CursoService, AlumnoService AlumS,TituloService TituloService,AsignaturaService AsignaturaService, PasswordEncoder passwordEncoder) {
		return args -> {





					String currentDirectory = System.getProperty ("user.dir");
					System.out.println ("user.dir:" + currentDirectory);
			System.out.println("-----------------------------------------------------------------------------------------------");

			Profesor p1=new Profesor(999,"luismi@gmail.com",passwordEncoder.encode("1234"),"Luismi","Lopez","4200000000Z","955213930",LocalDate.now(),null,true,false);
			Profesor p2=new Profesor(1000,"angel@gmail.com",passwordEncoder.encode("1234"),"Angel","Lopez","4100000000Z","955213930",LocalDate.now(),null,true,true);

			ProfS.save(p1);
			ProfS.save(p2);


			List<SituacionExepcional> situacionExepcional1dam = new ArrayList<>();
			List<SolicitudAmpliacionMatricula> solicitudAmpliacionMatricula1dam = new ArrayList<>();
			List<Curso> curso1dam = new ArrayList<>();
			List<Asignatura> asignaturasList1dam = new ArrayList<>();
			List<Alumno> alumnoList1dam = new ArrayList<>();
			List<Horario> horario1dam = new ArrayList<>();


			Curso c1 = new Curso("1ºDesarrollo de aplicaciones multiplataformas",true,alumnoList1dam,asignaturasList1dam,null );


			List<Curso> curso2dam = new ArrayList<>();
			List<Asignatura> asignaturasList2dam = new ArrayList<>();
			List<Alumno> alumnoList2dam = new ArrayList<>();
			List<Horario> horario2dam = new ArrayList<>();


			Titulo t2=new Titulo("Desarrollo de aplicaciones multiplataformas",true,curso1dam);
			Curso c2 = new Curso("2ºDesarrollo de aplicaciones multiplataformas",true,alumnoList1dam,asignaturasList1dam ,t2);


			TituloService.save(t2);
			CursoService.save(c1);
			CursoService.save(c2);




			//1dam
			Asignatura asg1=new Asignatura("Base de datos",true,c1);
			Asignatura asg2=new Asignatura("Programación",true,c1);
			Asignatura asg3=new Asignatura("Lenguaje de marcas",true,c1);
			Asignatura asg4=new Asignatura("Sistemas",true,c1);
			//2dam
			Asignatura asg5=new Asignatura("Acceso a datos",true,c2);
			Asignatura asg6=new Asignatura("Sistema de gestión empresarial",true,c2);
			Asignatura asg7=new Asignatura("Desarrollo de interfaces",true,c2);
			Asignatura asg8=new Asignatura("FOP",true,c2);


			Horario h1=new Horario(1,1,true,asg5);
			Horario h2=new Horario(1,2,true,asg5);

			asg5.addHorario(h1);
			asg5.addHorario(h2);

			AsignaturaService.save(asg1);
			AsignaturaService.save(asg2);
			AsignaturaService.save(asg3);
			AsignaturaService.save(asg4);
			AsignaturaService.save(asg5);
			AsignaturaService.save(asg6);
			AsignaturaService.save(asg7);
			AsignaturaService.save(asg8);





			//eE.sendEmail(a1,"prueba","esto es una prueba para developers");
			Alumno a1=new Alumno(10000, "cayetanog2000@gmail.com", passwordEncoder.encode("1234"), "Cayetano", "García Martín", "4900000000Z", "684213930", LocalDate.now(),null,true,c2);
			Alumno a2=new Alumno(10001, "garciamacay20@gmail.com", passwordEncoder.encode("1234"), "Juan", "lopez gomara", "4902300000Z", "652113924", LocalDate.now(),null,true,c1);
			Alumno a3=new Alumno(10002, "mudpik747@gmail.com", passwordEncoder.encode("1234"), "Pepe", "García Martín", "4900120000Z", "684212121", LocalDate.now(),null,true,c2);

			AlumS.save(a1);
			AlumS.save(a2);
			AlumS.save(a3);
		};


	}
}
