package com.forumhub.controller.topicos;

import com.forumhub.domain.topico.*;
import com.forumhub.domain.topico.DadosDetalhamentoTopico;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topics")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity criarNovoTopico(@RequestBody @Valid DadosCadastroTopico dados) {
        var topico = topicoService.cadastrar(dados);

        return ResponseEntity.ok(topico);
    }

    @GetMapping("/{id}/details")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = topicoService.detalhar(id);

        return ResponseEntity.ok(topico);
    }

    @PutMapping("/{id}/update")
    @Transactional
    public ResponseEntity atualizar(@RequestBody @ Valid DadosAtualizacaoTopico dados, @PathVariable Long id) {
        var topico = topicoService.atualizar(dados, id);

        return ResponseEntity.ok(topico);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<DadosDetalhamentoTopico>> listar(@PageableDefault(size = 10, sort = "dataCriacao", direction = Sort.Direction.DESC) Pageable paginacao) {
        var page = topicoRepository.findAll(paginacao).map(DadosDetalhamentoTopico::new);
        return ResponseEntity.ok(page);
    }


    @DeleteMapping("/{id}/delete")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {

        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
