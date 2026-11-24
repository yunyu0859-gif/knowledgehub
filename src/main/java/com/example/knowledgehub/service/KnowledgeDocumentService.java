package com.example.knowledgehub.service;

import com.example.knowledgehub.dto.CreateKnowledgeDocumentRequest;
import com.example.knowledgehub.model.KnowledgeDocument;
import java.util.List;

public interface KnowledgeDocumentService {
    List<KnowledgeDocument> findByKnowledgeBaseId(Long knowledgeBaseId, String title);

    List<KnowledgeDocument> search(Long knowledgeBaseId, String keyword);

    void create(Long knowledgeBaseId, CreateKnowledgeDocumentRequest request);
}
