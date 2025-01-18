package com.forumhub.domain.usuario.validacoes.atualizacao;

import com.forumhub.domain.ValidacaoException;
import com.forumhub.domain.usuario.DadosAtualizacaoUsuario;
import org.springframework.stereotype.Component;

@Component("validarNovaSenha")
public class ValidarNovaSenha implements ValidadorAtualizacaoDeUsuarios {

    public void validar(DadosAtualizacaoUsuario dados, Long id) {
        if (dados.senhaNova() != null && dados.senhaNova().equals(dados.senhaAtual())) {
            throw new ValidacaoException("A nova senha não pode ser a mesma que a anterior.");
        }
    }
}
