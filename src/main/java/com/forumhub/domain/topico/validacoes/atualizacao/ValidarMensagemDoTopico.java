package com.forumhub.domain.topico.validacoes.atualizacao;

import com.forumhub.domain.ValidacaoException;
import com.forumhub.domain.topico.DadosAtualizacaoTopico;
import com.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("validarMensagemAtualizacao")
public class ValidarMensagemDoTopico implements ValidadorAtualizacaoDeTopicos{

    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DadosAtualizacaoTopico dados, Long id) {

        if (topicoRepository.obterMensagemPeloId(id).equals(dados.mensagem())){
            throw new ValidacaoException("A Mensagem não pode ser o mesma!");
        }

        if (topicoRepository.existsByMensagem(dados.mensagem())){
            throw new ValidacaoException("Já existe um Tópico com esta mensagem!");
        }
    }
}
