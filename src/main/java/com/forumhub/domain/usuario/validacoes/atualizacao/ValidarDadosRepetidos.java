package com.forumhub.domain.usuario.validacoes.atualizacao;

import com.forumhub.domain.ValidacaoException;
import com.forumhub.domain.usuario.DadosAtualizacaoUsuario;
import com.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("validarDadosRepetidos")
public class ValidarDadosRepetidos implements ValidadorAtualizacaoDeUsuarios{

    @Autowired
    private UsuarioRepository repository;

    public void validar(DadosAtualizacaoUsuario dados, Long id) {

        if (repository.existsByLogin(dados.login())){
            throw new ValidacaoException("Já existe um cadastro com este e-mail!");
        }
        if (repository.existsByNomeDeUsuario(dados.nomeDeUsuario())){
            throw new ValidacaoException("Já existe um cadastro com este nome de usuario!");
        }

    }
}
