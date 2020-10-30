package com.gestor.instituto.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Getter@Setter
@Entity
public class SituacionExepcional  implements Serializable {

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

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha_solicitud;
    private String tipo;
    private String adjunto;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha_resolucion;
    private String estado;

    public SituacionExepcional(Alumno alumno, Asignatura asignatura, LocalDate fecha_solicitud, String adjunto, LocalDate fecha_resolucion, String estado) {
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.fecha_solicitud = fecha_solicitud;
        this.adjunto = adjunto;
        this.fecha_resolucion = fecha_resolucion;
        this.estado = estado;
    }

    public SituacionExepcional(Alumno alumno, Asignatura asignatura, LocalDate fecha_solicitud, String tipo, String adjunto, LocalDate fecha_resolucion, String estado) {
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.fecha_solicitud = fecha_solicitud;
        this.tipo = tipo;
        this.adjunto = adjunto;
        this.fecha_resolucion = fecha_resolucion;
        this.estado = estado;
    }

    public SituacionExepcional(Alumno alumno, Asignatura asignatura) {
        this.alumno = alumno;
        this.asignatura = asignatura;
    }
}
