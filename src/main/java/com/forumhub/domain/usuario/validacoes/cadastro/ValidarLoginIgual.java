package com.forumhub.domain.usuario.validacoes.cadastro;

import com.forumhub.domain.ValidacaoException;
import com.forumhub.domain.usuario.DadosCadastroUsuario;
import com.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("validarLoginIgual")
public class ValidarLoginIgual implements ValidadorCadastroDeUsuarios{

    @Autowired
    private UsuarioRepository repository;

    public void validar(DadosCadastroUsuario dados) {
        if (repository.existsByLogin(dados.login())){
            throw new ValidacaoException("Já existe um cadastro com este e-mail!");
        }
    }
}
