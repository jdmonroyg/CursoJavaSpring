package com.cursojava.curso.domain.usuario;

import ch.qos.logback.core.net.SMTPAppenderBase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author jdmon on 20/10/2023.
 * @project curso
 */
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByEmail(String email);
}


