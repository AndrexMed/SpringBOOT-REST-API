package com.voll.medic.api.infra.security;

import com.voll.medic.api.domain.usuarios.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("El filtro esta siendo llamado! - Inicio");

        //Obtener el token del header
        var authHeader = request.getHeader("Authorization");

        //System.out.println("Estado del token entrante: " +authHeader);

        if (authHeader != null) {
            System.out.println("Validamos que el token no fue nulo!");
            var token = authHeader.replace("Bearer ", "");

            var nombreUsuario = tokenService.getSubject(token);

            if (nombreUsuario != null){
                System.out.println("Nombre de Usuario : " + nombreUsuario);
                //Token valido
                var usuario = usuarioRepository.findByLogin(nombreUsuario);
                var autenticacion = new UsernamePasswordAuthenticationToken(usuario,
                                                                    null,
                                                                                usuario.getAuthorities()); //Forzamos inicio de sesion
                SecurityContextHolder.getContext().setAuthentication(autenticacion);
            }
        }
        filterChain.doFilter(request, response);

    }

}
