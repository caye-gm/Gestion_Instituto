package com.gestor.instituto.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor@AllArgsConstructor
@Entity
public class Alumno extends Usuario{

    public Alumno(long id, String email, String password, String nombre, String apellidos, String dni, String numeroTlf, LocalDate fecha_nac, String validacion, boolean estado, Curso curso) {
        super(id, email, password, nombre, apellidos, dni, numeroTlf, fecha_nac, validacion, estado);
        this.curso = curso;
    }



    public Alumno(long id, String email, String password, String nombre, String apellidos, String dni, String numeroTlf, LocalDate fecha_nac, String validacion, boolean estado, List<SituacionExepcional> situacionExepcional) {
        super(id, email, password, nombre, apellidos, dni, numeroTlf, fecha_nac, validacion, estado);
        this.situacionExepcional = situacionExepcional;
    }

    public Alumno(long id, String email, String password, String nombre, String apellidos, String dni, String numeroTlf, LocalDate fecha_nac, String validacion, boolean estado) {
        super(id, email, password, nombre, apellidos, dni, numeroTlf, fecha_nac, validacion, estado);
    }

    // Mantenemos esta lista, pero no añadimos helpers
    // Si queremos rellenar la lista, realizamos un JOIN FETCH
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy="alumno", fetch = FetchType.EAGER)
    private List<SituacionExepcional> situacionExepcional = new ArrayList<>();


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy="alumno", fetch = FetchType.EAGER)
    private List<SolicitudAmpliacionMatricula> SolicitudAmpliacionMatricula = new ArrayList<>();


    @ManyToOne
    private Curso curso;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ALUMNO"));
    }
}
