package com.forumhub.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByTitulo(String titulo);

    boolean existsByMensagem(String mensagem);

    Topico findByMensagem(String mensagem);

    @Query("""
            SELECT t.usuario.id
            FROM Topico t
            WHERE t.id = :idTopico
            """)
    Optional<Long> obterUserIdPeloTopicId(String idTopico);

    @Query("""
            SELECT t.titulo
            FROM Topico t
            WHERE t.id = :id
            """)
    String obterTituloPeloId(Long id);

    @Query("""
            SELECT t.mensagem
            FROM Topico t
            WHERE t.id = :id
            """)
    String obterMensagemPeloId(Long id);

    @Modifying
    @Query("""
            UPDATE Topico t SET t.usuario.id = -1 WHERE usuario.id = :id
            """)
    void mudarIdAutorParaUserDefault(Long id);
}
