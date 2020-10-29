package com.gestor.instituto.models;



import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
@Getter@Setter
@NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity

public abstract class Usuario implements UserDetails {

    private static final long serialVersionUID = 4932924958521868350L;



    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String email;
    private String password;
    private String nombre;
    private String apellidos;
    @Column(unique = true)
    private String dni;
    private String numeroTlf;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_nac;
    private String validacion;
    private boolean estado;



    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return estado;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }








}
