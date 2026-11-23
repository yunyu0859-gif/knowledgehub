package com.example.knowledgehub.model;

import java.time.LocalDateTime;

public record KnowledgeBase(
    Long id,
    String name,
    String description,
    LocalDateTime createdAt
) {}