package com.forumhub.domain.usuario.validacoes.cadastro;

import com.forumhub.domain.ValidacaoException;
import com.forumhub.domain.usuario.DadosCadastroUsuario;
import com.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("validarNomeUsuarioIgual")
public class ValidarNomeUsuarioIgual implements ValidadorCadastroDeUsuarios {

    @Autowired
    private UsuarioRepository repository;

    public void validar(DadosCadastroUsuario dados) {
        if (repository.existsByNomeDeUsuario(dados.nomeDeUsuario())){
            throw new ValidacaoException("Já existe um cadastro com este nome de usuario!");
        }
    }
}