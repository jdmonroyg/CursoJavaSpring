package com.cursojava.curso.domain.usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Service;
/**
 * @author jdmon on 30/10/2023
 * @project curso
 */
@Service
public class UsuarioService {
    private final Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
    public String hashPassword (char [] passwordChars ){
        return argon2.hash(1,1024,1,passwordChars);
    }
    public boolean verifyPassword (String hashedPassword,char [] passwordChars ){
        return argon2.verify(hashedPassword,passwordChars);
    }

}
