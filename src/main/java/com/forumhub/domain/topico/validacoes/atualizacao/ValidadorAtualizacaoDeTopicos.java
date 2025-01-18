package com.forumhub.domain.topico.validacoes.atualizacao;

import com.forumhub.domain.topico.DadosAtualizacaoTopico;

public interface ValidadorAtualizacaoDeTopicos {
    void validar(DadosAtualizacaoTopico dados, Long id);
}
