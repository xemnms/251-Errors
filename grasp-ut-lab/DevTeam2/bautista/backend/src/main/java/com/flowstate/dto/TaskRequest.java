package com.flowstate.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TaskRequest {

    @NotBlank(
        message = "Title is required"
    )
    private String title;

    private String description;

    @NotBlank(
        message = "Status is required"
    )
    private String status;
}