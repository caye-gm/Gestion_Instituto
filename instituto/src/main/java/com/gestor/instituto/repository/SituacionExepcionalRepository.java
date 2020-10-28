package com.gestor.instituto.repository;

import com.gestor.instituto.models.Profesor;
import com.gestor.instituto.models.SituacionExepcional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituacionExepcionalRepository extends JpaRepository<SituacionExepcional,Long> {
}
