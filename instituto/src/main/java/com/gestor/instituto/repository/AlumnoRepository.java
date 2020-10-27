package com.gestor.instituto.repository;

import com.gestor.instituto.models.Alumno;
import com.gestor.instituto.models.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AlumnoRepository extends JpaRepository<Alumno,Long> {


    @Query("select e from Alumno e where e.curso.asignaturas = :ASIGNATURA")
    public List<Alumno> alumnoAsignatura(@Param("ASIGNATURA")Asignatura asignatura);


}
