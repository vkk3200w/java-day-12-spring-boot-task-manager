package com.example.day12api.dto;

public record TaskResponse(
        Long id,
        String title,
        String description,
        boolean completed
) {
}