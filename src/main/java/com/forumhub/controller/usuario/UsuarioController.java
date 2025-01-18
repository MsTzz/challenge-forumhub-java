package com.forumhub.controller.usuario;

import com.forumhub.domain.usuario.UsuarioService;
import com.forumhub.domain.usuario.DadosAtualizacaoUsuario;
import com.forumhub.domain.usuario.DadosCadastroUsuario;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/register")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder) {
        var dto = usuarioService.cadastrar(dados);

        var uri = uriBuilder.path("/{id}/details").buildAndExpand(dto.id()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @SecurityRequirement(name = "bearer-key")
    @GetMapping("/{id}/details")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var usuario = usuarioService.detalhar(id);

       return ResponseEntity.ok(usuario);
    }

    @SecurityRequirement(name = "bearer-key")
    @PutMapping("/{id}/update")
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados, @PathVariable Long id) {
        var usuario = usuarioService.atualizar(dados, id);

        return ResponseEntity.ok(usuario);
    }

    @SecurityRequirement(name = "bearer-key")
    @DeleteMapping("/{id}/delete")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        usuarioService.deletar(id);

        return ResponseEntity.noContent().build();
    }

}
