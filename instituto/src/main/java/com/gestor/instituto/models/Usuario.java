package com.gestor.instituto.models;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

 @NoArgsConstructor @AllArgsConstructor
 @MappedSuperclass
public abstract class Usuario {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private String password;
    private String nombre;
    private String apellidos;
    private String dni;
    private String numeroTlf;
    private LocalDate fecha_nac;






}
