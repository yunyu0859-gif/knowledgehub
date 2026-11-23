package com.example.knowledgehub.dto;

public record CreateKnowledgeBaseRequest(
    String name,
    String description
) {}