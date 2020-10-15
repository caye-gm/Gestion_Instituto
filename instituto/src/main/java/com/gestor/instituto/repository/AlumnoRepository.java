package com.gestor.instituto.repository;

import com.gestor.instituto.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AlumnoRepository extends JpaRepository<Alumno,Long> {
}
