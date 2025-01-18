package com.forumhub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoUsuario(
            String nomeDeUsuario,

            @Email
            String login,

            @NotBlank
            String senhaAtual,

            @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*]).{6,15}")
            String senhaNova ) {

    }

