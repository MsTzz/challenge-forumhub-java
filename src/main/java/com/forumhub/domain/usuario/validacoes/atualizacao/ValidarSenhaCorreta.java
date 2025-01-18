package com.forumhub.domain.usuario.validacoes.atualizacao;

import com.forumhub.domain.usuario.DadosAtualizacaoUsuario;
import com.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("validarSenhaCorreta")
public class ValidarSenhaCorreta implements ValidadorAtualizacaoDeUsuarios {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(DadosAtualizacaoUsuario dados, Long id) {
        System.out.println(dados.senhaAtual());
        System.out.println(usuarioRepository.findSenhaById(id));
        if (!passwordEncoder.matches(dados.senhaAtual(), usuarioRepository.findSenhaById(id))){
            throw new RuntimeException("Senha do login está errada!");
        }
    }
}
