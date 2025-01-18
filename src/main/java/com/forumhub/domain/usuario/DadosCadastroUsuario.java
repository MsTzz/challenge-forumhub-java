package com.forumhub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroUsuario (

    @NotBlank
    String nomeDeUsuario,

    @NotBlank
    @Email
    String login,

    @NotBlank
    @Pattern(
            regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*Çç]).{6,15}",
            message = "A senha deve ter entre 6 e 15 caracteres, contendo pelo menos um número, uma letra e um caractere especial!."
    )
    String senha){
}