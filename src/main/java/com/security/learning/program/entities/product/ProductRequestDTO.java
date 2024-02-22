package com.security.learning.program.entities.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequestDTO(
        @NotBlank
        @NotNull
        String name,
        @Positive
        @NotNull
        BigDecimal price) {

}
