package com.gestor.instituto.repository;

import com.gestor.instituto.models.Asignatura;
import com.gestor.instituto.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {
}
