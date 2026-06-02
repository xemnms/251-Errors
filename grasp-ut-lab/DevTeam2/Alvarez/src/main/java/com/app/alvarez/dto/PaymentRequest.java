package com.app.alvarez.dto;

import com.app.alvarez.entity.PaymentMethod;
import jakarta.validation.constraints.NotNull;

public record PaymentRequest(@NotNull PaymentMethod method) {
}