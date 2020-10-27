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

			List<Horario> horario1dam = new ArrayList<>();


			Curso c1 = new Curso("1ºDesarrollo de aplicaciones multiplataformas",true,null );





			Titulo t2=new Titulo("Desarrollo de aplicaciones multiplataformas",true);
			Curso c2 = new Curso("2ºDesarrollo de aplicaciones multiplataformas",true );
			t2.addCurso(c2);

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



			AsignaturaService.save(asg1);
			AsignaturaService.save(asg2);
			AsignaturaService.save(asg3);
			AsignaturaService.save(asg4);
			AsignaturaService.save(asg5);
			AsignaturaService.save(asg6);
			AsignaturaService.save(asg7);
			AsignaturaService.save(asg8);

			Horario h1=new Horario(1,1,true,asg5);
			Horario h2=new Horario(1,2,true,asg5);
			Horario h3=new Horario(1,3,true,asg6);
			Horario h4=new Horario(1,4,true,asg7);
			Horario h5=new Horario(1,5,true,asg7);
			Horario h6=new Horario(1,6,true,asg7);
			Horario h7=new Horario(2,1,true,asg8);
			Horario h8=new Horario(2,2,true,asg6);
			Horario h9=new Horario(2,3,true,asg6);
			Horario h10=new Horario(2,4,true,asg5);
			Horario h11=new Horario(2,5,true,asg5);
			Horario h12=new Horario(2,6,true,asg6);
			Horario h13=new Horario(3,1,true,asg5);
			Horario h14=new Horario(3,2,true,asg5);
			Horario h15=new Horario(3,3,true,asg5);
			Horario h16=new Horario(3,4,true,asg5);
			Horario h17=new Horario(3,5,true,asg5);
			Horario h18=new Horario(3,6,true,asg5);
			Horario h19=new Horario(4,1,true,asg5);
			Horario h20=new Horario(4,2,true,asg5);
			Horario h21=new Horario(4,3,true,asg5);
			Horario h22=new Horario(4,4,true,asg5);
			Horario h23=new Horario(4,5,true,asg5);
			Horario h24=new Horario(4,6,true,asg5);

			hh.save(h1);
			hh.save(h2);
			hh.save(h3);
			hh.save(h4);
			hh.save(h5);
			hh.save(h6);
			hh.save(h7);
			hh.save(h8);
			hh.save(h9);
			hh.save(h10);
			hh.save(h11);
			hh.save(h12);
			hh.save(h13);
			hh.save(h14);
			hh.save(h15);
			hh.save(h16);
			hh.save(h17);
			hh.save(h18);
			hh.save(h19);
			hh.save(h20);
			hh.save(h21);
			hh.save(h22);
			hh.save(h23);
			hh.save(h24);



			asg5.addHorario(h1);
			asg5.addHorario(h2);
			asg6.addHorario(h3);
			asg7.addHorario(h4);
			asg7.addHorario(h5);
			asg7.addHorario(h6);
			asg8.addHorario(h7);
			asg6.addHorario(h8);
			asg6.addHorario(h9);
			asg5.addHorario(h10);
			asg5.addHorario(h11);
			asg5.addHorario(h12);
			asg5.addHorario(h13);
			asg5.addHorario(h14);
			asg5.addHorario(h15);
			asg5.addHorario(h16);
			asg5.addHorario(h17);
			asg5.addHorario(h18);
			asg5.addHorario(h19);
			asg5.addHorario(h20);
			asg5.addHorario(h21);
			asg5.addHorario(h22);
			asg5.addHorario(h23);
			asg5.addHorario(h24);




			//eE.sendEmail(a1,"prueba","esto es una prueba para developers");
			Alumno a1=new Alumno(10000, "cayetanog2000@gmail.com", passwordEncoder.encode("1234"), "Cayetano", "García Martín", "4900000000Z", "684213930", LocalDate.now(),null,true);
			Alumno a2=new Alumno(10001, "garciamacay20@gmail.com", passwordEncoder.encode("1234"), "Juan", "lopez gomara", "4902300000Z", "652113924", LocalDate.now(),null,true);
			Alumno a3=new Alumno(10002, "mudpik747@gmail.com", passwordEncoder.encode("1234"), "Pepe", "García Martín", "4900120000Z", "684212121", LocalDate.now(),null,true);



			c1.addAlumno(a2);
			c2.addAlumno(a1);
			c2.addAlumno(a3);
			AlumS.save(a1);
			AlumS.save(a2);
			AlumS.save(a3);




	};


	}
}
