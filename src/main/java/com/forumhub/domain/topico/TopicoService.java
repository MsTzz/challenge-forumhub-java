package com.forumhub.domain.topico;

import com.forumhub.domain.topico.validacoes.atualizacao.ValidadorAtualizacaoDeTopicos;
import com.forumhub.domain.topico.validacoes.cadastro.ValidadorCadastroDeTopicos;
import com.forumhub.domain.usuario.UsuarioRepository;
import com.forumhub.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private List<ValidadorCadastroDeTopicos> validadoresCadastroTopico;

    @Autowired
    private List<ValidadorAtualizacaoDeTopicos> validadorAtualizacaoTopicos;

    public DadosDetalhamentoTopico cadastrar(DadosCadastroTopico dados){
        validadoresCadastroTopico.forEach(v -> v.validar(dados));
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var login = authentication.getName();

        var usuario = usuarioRepository.findOptionalByLogin(login)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + login));

        var topico = new Topico(dados,usuario);
        topicoRepository.save(topico);

        return new DadosDetalhamentoTopico(topico);

    }

    public DadosDetalhamentoTopico detalhar(Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return new DadosDetalhamentoTopico(topico);
    }

    public DadosDetalhamentoTopico atualizar(DadosAtualizacaoTopico dados, Long id) {
        var topico = topicoRepository.getReferenceById(id);

        validadorAtualizacaoTopicos.forEach(v -> v.validar(dados, id));
        topico.atualizarInformacoes(dados);

        return new DadosDetalhamentoTopico(topico);
    }

}
