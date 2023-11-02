package com.cursojava.curso.controllers;

import com.cursojava.curso.domain.usuario.DatosRegistroUsuario;
import com.cursojava.curso.domain.usuario.Usuario;
import com.cursojava.curso.domain.usuario.UsuarioRepository;
import com.cursojava.curso.domain.usuario.UsuarioService;
import com.cursojava.curso.infra.security.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdmon on 16/10/2023.
 * @project curso
 */
@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JWTUtil jwtUtil;


    @GetMapping()
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token){
        if(!validarToken(token)){
            return null;
        }
        return usuarioRepository.findAll();
    }

    @PostMapping()
    public void registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario){
        Usuario usuario=new Usuario(datosRegistroUsuario);
        char[] passwordChars = usuario.getPassword().toCharArray();
        String hash=usuarioService.hashPassword(passwordChars);
        usuario.setPassword(hash);
        usuarioRepository.save(usuario);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable Long id, @RequestHeader(value = "Authorization") String token){
        if(!validarToken(token)){
            return;
        }
        usuarioRepository.deleteById(id);
    }

    private boolean validarToken(String token){
        Usuario usuario=usuarioRepository.findById(Long.parseLong(jwtUtil.getKey(token))).orElse(null);
        return usuario!=null;
    }

}
