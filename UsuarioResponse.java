package com.exemplo.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados retornados após criação do usuário")
public class UsuarioResponse {

    @Schema(description = "ID gerado", example = "1")
    private Long id;

    @Schema(description = "Nome do usuário", example = "João Silva")
    private String nome;

    @Schema(description = "Idade do usuário", example = "25")
    private Integer idade;

    public UsuarioResponse(Long id, String nome, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public Integer getIdade() { return idade; }
}
