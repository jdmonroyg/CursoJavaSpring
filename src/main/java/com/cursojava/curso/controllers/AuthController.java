package com.cursojava.curso.controllers;

import com.cursojava.curso.domain.usuario.DatosLoginUsuario;
import com.cursojava.curso.domain.usuario.Usuario;
import com.cursojava.curso.domain.usuario.UsuarioRepository;
import com.cursojava.curso.domain.usuario.UsuarioService;
import com.cursojava.curso.infra.security.JWTUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author jdmon on 30/10/2023
 * @project curso
 */

@RestController
@RequestMapping("api/login")
public class AuthController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping()
    public String login(@RequestBody @Valid DatosLoginUsuario datosLoginUsuario){
        char[] passwordChars = datosLoginUsuario.password().toCharArray();
        Usuario usuario= usuarioRepository.findByEmail(datosLoginUsuario.email()).orElse(null);
        if (usuario!=null &&
                usuarioService.verifyPassword(usuario.getPassword(),
                        passwordChars)){
            System.out.println("aqui");
            return jwtUtil.create(String.valueOf(usuario.getId()), usuario.getEmail());
        }else return "";
    }
}
