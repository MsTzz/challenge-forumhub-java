package com.forumhub.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByNomeDeUsuario(String nomeDeUsuario);

    boolean existsByLogin(String login);

    Usuario findByLogin(String login);

    Optional<Usuario> findOptionalByLogin(String login);

    @Query("SELECT u.senha FROM Usuario u WHERE u.id = :id")
    String findSenhaById(Long id);

}
