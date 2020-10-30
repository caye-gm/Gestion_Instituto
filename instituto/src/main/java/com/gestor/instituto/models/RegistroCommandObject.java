package com.gestor.instituto.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroCommandObject {
    private String email;
    private String pass;
    private String validacion;

}
