package com.gestor.instituto.models;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@NoArgsConstructor @AllArgsConstructor
 @MappedSuperclass
public abstract class Usuario implements UserDetails {

    private static final long serialVersionUID = 4932924958521868350L;



    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String email;
    private String password;
    @Column(unique = true)
    private String nombre;
    @Column(unique = true)
    private String apellidos;
    @Column(unique = true)
    private String dni;
    private String numeroTlf;
    @Column(unique = true)
    private LocalDate fecha_nac;

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
        return true;
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
