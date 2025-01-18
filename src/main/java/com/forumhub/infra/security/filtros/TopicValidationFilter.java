package com.forumhub.infra.security.filtros;

import com.forumhub.domain.usuario.Usuario;
import com.forumhub.domain.topico.TopicoRepository;
import com.forumhub.domain.usuario.UsuarioRepository;
import com.forumhub.infra.security.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class TopicValidationFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    private static final List<String> URL_PATTERNS = List.of(
            "/topics/\\d+/details",
            "/topics/\\d+/update",
            "/topics/\\d+/delete"
    );

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (shouldValidate(request)) {
            var tokenJWT = recuperarToken(request);
            var subject = tokenService.getSubject(tokenJWT);
            var usuario = usuarioRepository.findOptionalByLogin(subject)
                    .orElseThrow(() -> new AccessDeniedException("Usuário não encontrado!"));

            validarAutorTopico(request.getRequestURI(), usuario, response);
        }

        filterChain.doFilter(request, response);
    }

    private boolean shouldValidate(HttpServletRequest request) {
        String uri = request.getRequestURI();
        return URL_PATTERNS.stream().anyMatch(uri::matches);
    }

    private void validarAutorTopico(String requestURI, Usuario usuario, HttpServletResponse response) {
        String[] uriParts = requestURI.split("/");
        String idNaUrl = uriParts[2];;



        var idAutor = topicoRepository.obterUserIdPeloTopicId(idNaUrl)
                .orElseThrow(() -> new RuntimeException("O tópico de ID: " + idNaUrl + " não existe!"));

        if (!usuario.getId().equals(idAutor)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            throw new AccessDeniedException("Você não tem permissão para esse tópico!");
        }
    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        return (authorizationHeader != null) ? authorizationHeader.replace("Bearer ", "") : null;
    }
}

