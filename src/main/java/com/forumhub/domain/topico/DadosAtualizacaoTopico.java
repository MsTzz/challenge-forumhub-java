package com.forumhub.domain.topico;

import jakarta.validation.constraints.Size;

public record DadosAtualizacaoTopico (

        @Size(max = 150, message = "O título não pode ter mais de 150 caracteres.")
        String titulo,

        @Size(max = 250, message = "A mensagem não pode ter mais de 250 caracteres.")
        String mensagem,

    EstadoTopico estadoTopico){

}
