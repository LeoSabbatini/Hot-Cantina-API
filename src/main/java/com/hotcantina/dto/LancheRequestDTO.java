package com.hotcantina.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record LancheRequestDTO(
        @NotBlank(message = "Informe o nome do lanche")
        @Size(min = 1, max = 150, message = "O nome do lanche deve ter entre 1 e 150 caracteres")
        String nome,

        @NotNull(message = "Informe o preco do lanche")
        @Positive(message = "O preço deve ser maior que zero")
        BigDecimal preco,

        String descricao

) {
}
