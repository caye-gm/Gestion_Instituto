package com.gestor.instituto.models;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Builder @Data
@Getter@Setter
@NoArgsConstructor @AllArgsConstructor
public class SituacionExepcionalCommandObject {

        private long idAsignatura;

    }
