package com.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroTopico(
        @NotBlank
        @Size(max = 150, message = "O título não pode ter mais de 150 caracteres.")
        String titulo,
        @NotBlank
        @Size(max = 250, message = "A mensagem não pode ter mais de 250 caracteres.")
        String mensagem,
        @NotBlank
        String nomeCurso) {
}
