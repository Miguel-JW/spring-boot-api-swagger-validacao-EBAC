package com.exemplo.api.service;

import com.exemplo.api.dto.UsuarioRequest;
import com.exemplo.api.dto.UsuarioResponse;
import com.exemplo.api.entity.Usuario;
import com.exemplo.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Idempotente: se usuário com mesmo nome já existe, retorna o existente
    public UsuarioResponse criarOuRetornar(UsuarioRequest request) {
        Optional<Usuario> existente = usuarioRepository.findByNome(request.getNome());

        if (existente.isPresent()) {
            Usuario u = existente.get();
            return new UsuarioResponse(u.getId(), u.getNome(), u.getIdade());
        }

        Usuario novo = new Usuario(request.getNome(), request.getIdade());
        Usuario salvo = usuarioRepository.save(novo);
        return new UsuarioResponse(salvo.getId(), salvo.getNome(), salvo.getIdade());
    }
}
