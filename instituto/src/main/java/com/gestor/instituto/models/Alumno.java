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

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class Alumno extends Usuario{




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



    public Alumno(long id, String email, String password, String nombre, String apellidos, String dni, String numeroTlf, LocalDate fecha_nac) {
        super(id, email, password, nombre, apellidos, dni, numeroTlf, fecha_nac);
    }

    public Alumno(long id, String email, String password, String nombre, String apellidos, String dni, String numeroTlf, LocalDate fecha_nac, Curso curso) {
        super(id, email, password, nombre, apellidos, dni, numeroTlf, fecha_nac);
        this.curso = curso;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ALUMNO"));
    }
}
