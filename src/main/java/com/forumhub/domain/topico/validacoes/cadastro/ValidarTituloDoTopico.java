package com.forumhub.domain.topico.validacoes.cadastro;

import com.forumhub.domain.ValidacaoException;
import com.forumhub.domain.topico.DadosCadastroTopico;
import com.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("validarTituloCadastro")
public class ValidarTituloDoTopico implements ValidadorCadastroDeTopicos {

    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DadosCadastroTopico dados) {
        if (topicoRepository.existsByTitulo(dados.titulo())){
            throw new ValidacaoException("Já existe um Tópico com este título");
        }
    }
}
