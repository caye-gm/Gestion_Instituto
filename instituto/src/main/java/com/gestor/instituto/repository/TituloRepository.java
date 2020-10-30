package com.gestor.instituto.repository;

import com.gestor.instituto.models.Profesor;
import com.gestor.instituto.models.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TituloRepository extends JpaRepository<Titulo,Long> {
}
