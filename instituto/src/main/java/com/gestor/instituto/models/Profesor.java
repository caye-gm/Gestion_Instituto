package com.gestor.instituto.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Profesor extends Usuario{

    private boolean esJefeDeEstudio;

    public Profesor(long id, String email, String password, String nombre, String apellidos, String dni, String numeroTlf, LocalDate fecha_nac, boolean esJefeDeEstudio) {
        super(id, email, password, nombre, apellidos, dni, numeroTlf, fecha_nac);
        this.esJefeDeEstudio = esJefeDeEstudio;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        String role = "ROLE_";
        if (esJefeDeEstudio) {
            role += "JE";
        } else {
            role += "PROFESOR";
        }
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }
}
