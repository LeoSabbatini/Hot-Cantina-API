package com.hotcantina.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
public record LancheResponseDTO(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco
) {
}
