package com.app.costiniano.dto;

import java.util.List;

public record OrderRequestDto(List<ItemDto> items, String paymentMethod) {}