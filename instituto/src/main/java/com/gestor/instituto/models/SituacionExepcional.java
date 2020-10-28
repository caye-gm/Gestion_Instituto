package com.gestor.instituto.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Getter@Setter
@Entity
public class SituacionExepcional {

    @EmbeddedId
    private SituacionExep id = new SituacionExep();

    @ManyToOne
    @MapsId("alumno_id")
    @JoinColumn(name="alumno_id")
    private Alumno alumno;

    @ManyToOne
    @MapsId("asignatura_id")
    @JoinColumn(name="asignatura_id")
    private Asignatura asignatura;


    private LocalDate fecha_solicitud;
    private String tipo;
    private String adjunto;
    private LocalDate fecha_resolucion;
    private String estado;

    public SituacionExepcional(Alumno alumno, Asignatura asignatura) {
        this.alumno = alumno;
        this.asignatura = asignatura;
    }

    public SituacionExepcional(Alumno alumno, Asignatura asignatura, LocalDate fecha_solicitud, String tipo, File adjunto, LocalDate fecha_resolucion, String estado) {
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.fecha_solicitud = fecha_solicitud;
        this.tipo = tipo;
        adjunto = adjunto;
        this.fecha_resolucion = fecha_resolucion;
        this.estado = estado;
    }
}
