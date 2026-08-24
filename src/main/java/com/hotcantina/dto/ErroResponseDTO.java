package com.hotcantina.dto;

public record ErroResponseDTO(
        int status,
        String mensagem
) {
}