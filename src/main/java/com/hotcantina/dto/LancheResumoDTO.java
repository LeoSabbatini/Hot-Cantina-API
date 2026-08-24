package com.hotcantina.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record LancheResumoDTO(
        Long id,
        String nome,
        BigDecimal preco
) {
}
