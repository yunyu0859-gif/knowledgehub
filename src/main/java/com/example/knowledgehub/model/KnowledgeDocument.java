package com.example.knowledgehub.model;

import java.time.LocalDateTime;

public record KnowledgeDocument(
    Long id,
    Long knowledgeBaseId,
    String title,
    String content,
    LocalDateTime createdAt
) {}
