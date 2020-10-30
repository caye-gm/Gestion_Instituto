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

			Profesor p1=new Profesor(999,"luismi@gmail.com",passwordEncoder.encode("1234"),"Luismi","Lopez","4200000000Z","955213930",LocalDate.now(),null,true,false);
			Profesor p2=new Profesor(1000,"angel@gmail.com",passwordEncoder.encode("1234"),"Angel","Lopez","4109517500C","955213930",LocalDate.now(),null,true,true);
			Profesor p3=new Profesor(1001,"profesor",passwordEncoder.encode("profesor"),"Profesor","Teacher","3720000000Z","684232398",LocalDate.now(),null,true,false);
			Profesor p4=new Profesor(1002,"admin",passwordEncoder.encode("admin"),"admin","admin","8256008600D","6255856734",LocalDate.now(),null,true,true);
			Profesor p5=new Profesor(1003,"Pablo",passwordEncoder.encode("1234"),"Pablo","Escalante","1256368600A","6255856734",LocalDate.now(),null,true,false);

			ProfS.save(p1);
			ProfS.save(p2);
			ProfS.save(p3);
			ProfS.save(p4);

			Curso c1 = new Curso("1ºDesarrollo de aplicaciones multiplataformas",true,null );

			Titulo t2=new Titulo("Desarrollo de aplicaciones multiplataformas",true);
			Curso c2 = new Curso("2ºDesarrollo de aplicaciones multiplataformas",true );
			t2.addCurso(c2);

			TituloService.save(t2);
			CursoService.save(c1);
			CursoService.save(c2);


			//1dam
			Asignatura BBDD=new Asignatura("Base de datos",true,c1);
			Asignatura PRO=new Asignatura("Programación",true,c1);
			Asignatura LM=new Asignatura("Lenguaje de marcas",true,c1);
			Asignatura SI=new Asignatura("Sistemas Informáticos",true,c1);

			//2dam
			Asignatura AD=new Asignatura("Acceso a datos",true,c2);
			Asignatura SGE=new Asignatura("Sistema de gestión empresarial",true,c2);
			Asignatura DI=new Asignatura("Desarrollo de interfaces",true,c2);
			Asignatura FOP=new Asignatura("FOP",true,c2);
			Asignatura ING=new Asignatura("Ingles",true,c2);


			AsignaturaService.save(BBDD);
			AsignaturaService.save(PRO);
			AsignaturaService.save(LM);
			AsignaturaService.save(SI);

			AsignaturaService.save(AD);
			AsignaturaService.save(SGE);
			AsignaturaService.save(DI);
			AsignaturaService.save(FOP);
			AsignaturaService.save(ING);

			Horario h1=new Horario(1,1,true,AD);
			Horario h2=new Horario(1,2,true,AD);
			Horario h3=new Horario(1,3,true,SGE);
			Horario h4=new Horario(1,4,true,DI);
			Horario h5=new Horario(1,5,true,DI);
			Horario h6=new Horario(1,6,true,AD);
			Horario h7=new Horario(2,1,true,AD);
			Horario h8=new Horario(2,2,true,DI);
			Horario h9=new Horario(2,3,true,DI);
			Horario h10=new Horario(2,4,true,AD);
			Horario h11=new Horario(2,5,true,AD);
			Horario h12=new Horario(2,6,true,SGE);
			Horario h13=new Horario(3,1,true,AD);
			Horario h14=new Horario(3,2,true,FOP);
			Horario h15=new Horario(3,3,true,ING);
			Horario h16=new Horario(3,4,true,ING);
			Horario h17=new Horario(3,5,true,SGE);
			Horario h18=new Horario(3,6,true,SGE);
			Horario h19=new Horario(4,1,true,FOP);
			Horario h20=new Horario(4,2,true,AD);
			Horario h21=new Horario(4,3,true,AD);
			Horario h22=new Horario(4,4,true,SGE);
			Horario h23=new Horario(4,5,true,SGE);
			Horario h24=new Horario(4,6,true,FOP);
			Horario h25=new Horario(5,1,true,DI);
			Horario h26=new Horario(5,2,true,DI);
			Horario h27=new Horario(5,3,true,DI);
			Horario h28=new Horario(5,4,true,FOP);
			Horario h29=new Horario(5,5,true,ING);
			Horario h30=new Horario(5,6,true,ING);

			//1DAM

			Horario h31=new Horario(1,1,true,BBDD);
			Horario h32=new Horario(1,2,true,BBDD);
			Horario h33=new Horario(1,3,true,PRO);
			Horario h34=new Horario(1,4,true,SI);
			Horario h35=new Horario(1,5,true,SI);
			Horario h36=new Horario(1,6,true,LM);
			Horario h37=new Horario(2,1,true,PRO);
			Horario h38=new Horario(2,2,true,PRO);
			Horario h39=new Horario(2,3,true,BBDD);
			Horario h40=new Horario(2,4,true,LM);
			Horario h41=new Horario(2,5,true,LM);
			Horario h42=new Horario(2,6,true,LM);
			Horario h43=new Horario(3,1,true,SI);
			Horario h44=new Horario(3,2,true,BBDD);
			Horario h45=new Horario(3,3,true,PRO);
			Horario h46=new Horario(3,4,true,PRO);
			Horario h47=new Horario(3,5,true,PRO);
			Horario h48=new Horario(3,6,true,LM);
			Horario h49=new Horario(4,1,true,BBDD);
			Horario h50=new Horario(4,2,true,BBDD);
			Horario h51=new Horario(4,3,true,PRO);
			Horario h52=new Horario(4,4,true,LM);
			Horario h53=new Horario(4,5,true,SI);
			Horario h54=new Horario(4,6,true,SI);
			Horario h55=new Horario(5,1,true,LM);
			Horario h56=new Horario(5,2,true,PRO);
			Horario h57=new Horario(5,3,true,PRO);
			Horario h58=new Horario(5,4,true,SI);
			Horario h59=new Horario(5,5,true,BBDD);
			Horario h60=new Horario(5,6,true,BBDD);


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
			hh.save(h25);
			hh.save(h26);
			hh.save(h27);
			hh.save(h28);
			hh.save(h29);
			hh.save(h30);
			hh.save(h31);
			hh.save(h32);
			hh.save(h33);
			hh.save(h34);
			hh.save(h35);
			hh.save(h36);
			hh.save(h37);
			hh.save(h38);
			hh.save(h39);
			hh.save(h40);
			hh.save(h41);
			hh.save(h42);
			hh.save(h43);
			hh.save(h44);
			hh.save(h45);
			hh.save(h46);
			hh.save(h47);
			hh.save(h48);
			hh.save(h49);
			hh.save(h50);
			hh.save(h51);
			hh.save(h52);
			hh.save(h53);
			hh.save(h54);
			hh.save(h55);
			hh.save(h56);
			hh.save(h57);
			hh.save(h58);
			hh.save(h59);
			hh.save(h60);



			AD.addHorario(h1);
			AD.addHorario(h2);
			SGE.addHorario(h3);
			DI.addHorario(h4);
			DI.addHorario(h5);
			AD.addHorario(h6);
			AD.addHorario(h7);
			DI.addHorario(h8);
			DI.addHorario(h9);
			AD.addHorario(h10);
			AD.addHorario(h11);
			SGE.addHorario(h12);
			AD.addHorario(h13);
			FOP.addHorario(h14);
			ING.addHorario(h15);
			ING.addHorario(h16);
			SGE.addHorario(h17);
			SGE.addHorario(h18);
			FOP.addHorario(h19);
			AD.addHorario(h20);
			AD.addHorario(h21);
			SGE.addHorario(h22);
			SGE.addHorario(h23);
			FOP.addHorario(h24);
			DI.addHorario(h25);
			DI.addHorario(h26);
			DI.addHorario(h27);
			FOP.addHorario(h28);
			ING.addHorario(h29);
			ING.addHorario(h30);

			BBDD.addHorario(h31);
			BBDD.addHorario(h32);
			PRO.addHorario(h33);
			SI.addHorario(h34);
			SI.addHorario(h35);
			LM.addHorario(h36);
			PRO.addHorario(h37);
			PRO.addHorario(h38);
			BBDD.addHorario(h39);
			LM.addHorario(h40);
			LM.addHorario(h41);
			LM.addHorario(h42);
			/**/
			SI.addHorario(h43);
			BBDD.addHorario(h44);
			PRO.addHorario(h45);
			PRO.addHorario(h46);
			PRO.addHorario(h47);
			LM.addHorario(h48);
			BBDD.addHorario(h49);
			BBDD.addHorario(h50);
			PRO.addHorario(h51);
			LM.addHorario(h52);
			SI.addHorario(h53);
			SI.addHorario(h54);
			LM.addHorario(h55);
			PRO.addHorario(h56);
			PRO.addHorario(h57);
			SI.addHorario(h58);
			BBDD.addHorario(h59);
			BBDD.addHorario(h60);


			//eE.sendEmail(a1,"prueba","esto es una prueba para developers");
			Alumno a1=new Alumno(10000, "cayetanog2000@gmail.com", passwordEncoder.encode("1234"), "Cayetano", "García Martín", "4902340530Z", "684213930", LocalDate.now(),null,true);
			Alumno a2=new Alumno(10001, "garciamacay20@gmail.com", passwordEncoder.encode("1234"), "Juan", "lopez gomara", "4902300421Z", "652113924", LocalDate.now(),null,true);
			Alumno a3=new Alumno(10002, "mudpik747@gmail.com", passwordEncoder.encode("1234"), "Pepe", "García Martín", "4900122300Z", "684212121", LocalDate.now(),null,true);
			Alumno a4=new Alumno(10002, "usuario", passwordEncoder.encode("usuario"), "usuario", "usuario usuario", "4975699523Z", "623416521", LocalDate.now(),null,true);
			Alumno a5=new Alumno(10003, "juan@gmail.com", passwordEncoder.encode("1234"), "juan", "García Martín", "4905400000Z", "684213930", LocalDate.now(),null,true);
			Alumno a6=new Alumno(10004, "arbeloa@gmail.com", passwordEncoder.encode("1234"), "arbeloa", "Perez roman", "494981590Z", "652113924", LocalDate.now(),null,true);
			Alumno a7=new Alumno(10005, "joni@gmail.com", passwordEncoder.encode("1234"), "joni", "García Lopez", "234897219Z", "684213930", LocalDate.now(),null,true);
			Alumno a8=new Alumno(10006, "manuel@gmail.com", passwordEncoder.encode("1234"), "manuel", "lopez gomara", "318456917Z", "652113924", LocalDate.now(),null,true);
			Alumno a9=new Alumno(10007, "manuel_pokemon@gmail.com", passwordEncoder.encode("1234"), "manuel", "Padilla Gil", "974512638A", "684213930", LocalDate.now(),null,true);
			Alumno a10=new Alumno(10008, "adrian@gmail.com", passwordEncoder.encode("1234"), "Adrian", "Diaz Gomez", "4902300230X", "652113924", LocalDate.now(),null,true);
			Alumno a11=new Alumno(10009, "luismiguel@gmail.com", passwordEncoder.encode("1234"), "Luismi", "Costa Martín", "493120530C", "684213930", LocalDate.now(),null,true);
			Alumno a12=new Alumno(10011, "maria@gmail.com", passwordEncoder.encode("1234"), "Maria", "Macias gomara", "490230340D", "652113924", LocalDate.now(),null,true);
			Alumno a13=new Alumno(10012, "daniel@gmail.com", passwordEncoder.encode("1234"), "Daniel", "Lorenzo Gonzalez", "2345342000F", "684213930", LocalDate.now(),null,true);
			Alumno a14=new Alumno(10013, "carlos@gmail.com", passwordEncoder.encode("1234"), "Carlos", "Montero Lopez", "4908526500H", "652113924", LocalDate.now(),null,true);

			c1.addAlumno(a2);
			c2.addAlumno(a1);
			c2.addAlumno(a3);
			c2.addAlumno(a4);
			c2.addAlumno(a5);
			c2.addAlumno(a6);
			c2.addAlumno(a7);
			c2.addAlumno(a8);
			c1.addAlumno(a9);
			c1.addAlumno(a10);
			c1.addAlumno(a11);
			c1.addAlumno(a12);
			c2.addAlumno(a13);
			c2.addAlumno(a14);



			AlumS.save(a1);
			AlumS.save(a2);
			AlumS.save(a3);
			AlumS.save(a4);
			AlumS.save(a5);
			AlumS.save(a6);
			AlumS.save(a7);
			AlumS.save(a8);
			AlumS.save(a9);
			AlumS.save(a10);
			AlumS.save(a11);
			AlumS.save(a12);
			AlumS.save(a13);
			AlumS.save(a14);





	};


	}
}
