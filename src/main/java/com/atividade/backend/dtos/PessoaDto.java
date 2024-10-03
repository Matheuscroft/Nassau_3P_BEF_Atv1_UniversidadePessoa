package com.atividade.backend.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PessoaDto {
    @NotBlank
    private String nome;

    @NotBlank
    @Size(max=14)
    private String cpf;

    @NotNull(message = "A idade é obrigatória")
    @Min(value = 0, message = "A idade deve ser maior ou igual a 0")
    private int idade;

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @NotBlank @Size(max = 14) String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank @Size(max = 14) String cpf) {
        this.cpf = cpf;
    }

    @NotNull(message = "A idade é obrigatória")
    @Min(value = 0, message = "A idade deve ser maior ou igual a 0")
    public int getIdade() {
        return idade;
    }

    public void setIdade(@NotNull(message = "A idade é obrigatória") @Min(value = 0, message = "A idade deve ser maior ou igual a 0") int idade) {
        this.idade = idade;
    }
}


