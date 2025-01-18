package com.forumhub.domain.topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(String titulo, String mensagem, LocalDateTime dataCriacao, EstadoTopico estadoTopico, String autor, String curso) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(),topico.getEstadotopico(),topico.getUsuario().getNomeDeUsuario(), topico.getCurso());
    }
}
