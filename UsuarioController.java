package com.exemplo.api.controller;

import com.exemplo.api.dto.UsuarioRequest;
import com.exemplo.api.dto.UsuarioResponse;
import com.exemplo.api.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuários", description = "Endpoints para gerenciamento de usuários")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Operation(summary = "Criar usuário", description = "Cria um novo usuário ou retorna o existente (idempotente).")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Usuário criado ou retornado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    public ResponseEntity<UsuarioResponse> criar(@Valid @RequestBody UsuarioRequest request) {
        UsuarioResponse response = usuarioService.criarOuRetornar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
