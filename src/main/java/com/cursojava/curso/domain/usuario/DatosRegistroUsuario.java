package com.cursojava.curso.domain.usuario;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
/**
 * @author jdmon on 30/10/2023
 * @project curso
 */
public record DatosRegistroUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        String apellido,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefono,
        @NotBlank
        String password) {
}
