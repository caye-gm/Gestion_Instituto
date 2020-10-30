package com.gestor.instituto.repository;

import com.gestor.instituto.models.Curso;
import com.gestor.instituto.models.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<Horario,Long> {
}
