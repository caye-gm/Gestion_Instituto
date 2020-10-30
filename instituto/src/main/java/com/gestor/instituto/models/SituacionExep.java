package com.gestor.instituto.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data@AllArgsConstructor@NoArgsConstructor
public class SituacionExep implements Serializable {

    private static final long serialVersionUID = 8682909319466153524L;

    long alumno_id;

    long asignatura_id;


}
