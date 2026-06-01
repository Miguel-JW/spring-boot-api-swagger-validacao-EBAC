package com.exemplo.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados para criação de um usuário")
public class UsuarioRequest {

    @NotNull(message = "O nome não pode ser nulo.")
    @Size(min = 3, message = "O nome deve ter pelo menos 3 caracteres.")
    @Schema(description = "Nome do usuário", example = "João Silva", minLength = 3)
    private String nome;

    @NotNull(message = "A idade não pode ser nula.")
    @Positive(message = "A idade deve ser um número positivo.")
    @Schema(description = "Idade do usuário", example = "25")
    private Integer idade;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }
}
