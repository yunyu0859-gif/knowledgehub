package com.example.knowledgehub.service;

import com.example.knowledgehub.dto.CreateKnowledgeBaseRequest;
import com.example.knowledgehub.model.KnowledgeBase;
import java.util.List;

public interface KnowledgeBaseService {
    List<KnowledgeBase> findAll();

    void create(CreateKnowledgeBaseRequest request);
}
