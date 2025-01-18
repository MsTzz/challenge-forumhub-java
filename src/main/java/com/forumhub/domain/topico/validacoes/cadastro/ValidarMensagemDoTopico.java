package com.forumhub.domain.topico.validacoes.cadastro;

import com.forumhub.domain.ValidacaoException;
import com.forumhub.domain.topico.DadosCadastroTopico;
import com.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("validarMensagemCadastro")
public class ValidarMensagemDoTopico implements ValidadorCadastroDeTopicos {

    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DadosCadastroTopico dados) {
        if (topicoRepository.existsByMensagem(dados.mensagem())){
            var topico = topicoRepository.findByMensagem(dados.mensagem());
            throw new ValidacaoException("Já existe um Tópico com esta mensagem: " + "ID: " + topico.getId() + " Título: " + topico.getTitulo());
        }
    }
}
