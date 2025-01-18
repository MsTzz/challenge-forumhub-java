package com.forumhub.domain.topico.validacoes.atualizacao;

import com.forumhub.domain.ValidacaoException;
import com.forumhub.domain.topico.DadosAtualizacaoTopico;
import com.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("validarTituloAtualizacao")
public class ValidarTituloDoTopico implements ValidadorAtualizacaoDeTopicos {

    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DadosAtualizacaoTopico dados, Long id) {

        if (topicoRepository.obterTituloPeloId(id).equals(dados.titulo())){
            throw new ValidacaoException("O título não pode ser o mesmo!");
        }

        if (topicoRepository.existsByTitulo(dados.titulo())){
            throw new ValidacaoException("Já existe um Tópico com este título");
        }
    }
}
