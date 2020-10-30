package com.gestor.instituto.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;

    @Data

    @NoArgsConstructor
    @Entity
    public class SolicitudAmpliacionMatricula {

        @EmbeddedId
        private SolicitudAmp id = new SolicitudAmp();

        @ManyToOne
        @MapsId("alumno_id")
        @JoinColumn(name="alumno_id")
        private Alumno alumno;

        @ManyToOne
        @MapsId("asignatura_id")
        @JoinColumn(name="asignatura_id")
        private Asignatura asignatura;

        private LocalDate fecha_solicitud;
        private LocalDate fecha_resolucion;
        private String estado;


        public SolicitudAmpliacionMatricula(Alumno alumno, Asignatura asignatura) {
            this.alumno = alumno;
            this.asignatura = asignatura;
        }

        public SolicitudAmpliacionMatricula(Alumno alumno, Asignatura asignatura, LocalDate fecha_solicitud, LocalDate fecha_resolucion, String estado) {
            this.alumno = alumno;
            this.asignatura = asignatura;
            this.fecha_solicitud = fecha_solicitud;
            this.fecha_resolucion = fecha_resolucion;
            this.estado = estado;
        }
    }
