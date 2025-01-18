package com.forumhub.domain.usuario;

public record DadosDetalhamentoUsuario(Long id, String nomeDeUsuario, String login) {
    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNomeDeUsuario(), usuario.getLogin());
    }
}

