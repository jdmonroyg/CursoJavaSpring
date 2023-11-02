package com.cursojava.curso.domain.usuario;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author jdmon on 17/10/2023.
 * @project curso
 */
@Table (name = "usuarios")
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode (of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String password;

    public Usuario(DatosRegistroUsuario datosRegistroUsuario) {
        this.nombre=datosRegistroUsuario.nombre();
        this.apellido=datosRegistroUsuario.apellido();
        this.email=datosRegistroUsuario.email();
        this.telefono=datosRegistroUsuario.telefono();
        this.password=datosRegistroUsuario.password();
    }

}
