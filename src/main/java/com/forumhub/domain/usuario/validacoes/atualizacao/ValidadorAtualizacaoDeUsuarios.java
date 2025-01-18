package com.forumhub.domain.usuario.validacoes.atualizacao;

import com.forumhub.domain.usuario.DadosAtualizacaoUsuario;

public interface ValidadorAtualizacaoDeUsuarios {
    void validar(DadosAtualizacaoUsuario dados, Long id);
}

