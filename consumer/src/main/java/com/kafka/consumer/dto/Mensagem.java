package com.kafka.consumer.dto;

import java.math.BigDecimal;

public record Mensagem(
    Long id, 
    String nome, 
    String descricao, 
    BigDecimal valor
) {
    
}