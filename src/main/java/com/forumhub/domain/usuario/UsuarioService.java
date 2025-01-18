package com.forumhub.domain.usuario;

import com.forumhub.domain.topico.TopicoRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.forumhub.domain.usuario.validacoes.atualizacao.ValidadorAtualizacaoDeUsuarios;
import com.forumhub.domain.usuario.validacoes.cadastro.ValidadorCadastroDeUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private List<ValidadorCadastroDeUsuarios> validadoresCadastro;

    @Autowired
    private List<ValidadorAtualizacaoDeUsuarios> validadoresAtualizacao;

    public DadosDetalhamentoUsuario cadastrar(DadosCadastroUsuario dados){
        validadoresCadastro.forEach(v -> v.validar(dados));
        var senha = passwordEncoder.encode(dados.senha());

        var usuario = new Usuario(null, dados.nomeDeUsuario(), dados.login(), senha);
        usuarioRepository.save(usuario);

        return new DadosDetalhamentoUsuario(usuario);

    }

    public DadosDetalhamentoUsuario detalhar(Long id) {
        var usuario = usuarioRepository.getReferenceById(id);
        return new DadosDetalhamentoUsuario(usuario);
    }

    public DadosDetalhamentoUsuario atualizar(DadosAtualizacaoUsuario dados, Long id) {
        var usuario = usuarioRepository.getReferenceById(id);

        validadoresAtualizacao.forEach(v -> v.validar(dados, id));
        String senhaCodificada = null;

        if (dados.senhaNova() != null){
            senhaCodificada = passwordEncoder.encode(dados.senhaNova());
        }

        usuario.atualizarInformacoes(dados, senhaCodificada);
        return new DadosDetalhamentoUsuario(usuario);
    }

    public void deletar(Long id){
        var usuario = usuarioRepository.getReferenceById(id);
        topicoRepository.mudarIdAutorParaUserDefault(usuario.getId());
        usuarioRepository.delete(usuario);
        System.out.println("Usuario: " + usuario.getNomeDeUsuario() + " foi deletado!");
    }

}
