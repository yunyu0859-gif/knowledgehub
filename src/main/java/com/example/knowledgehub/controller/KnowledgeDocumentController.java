package com.example.knowledgehub.controller;

import com.example.knowledgehub.dto.CreateKnowledgeDocumentRequest;
import com.example.knowledgehub.model.KnowledgeDocument;
import com.example.knowledgehub.service.KnowledgeDocumentService;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/knowledge-bases/{knowledgeBaseId}/documents")
public class KnowledgeDocumentController {

    private final KnowledgeDocumentService knowledgeDocumentService;

    public KnowledgeDocumentController(KnowledgeDocumentService knowledgeDocumentService) {
        this.knowledgeDocumentService = knowledgeDocumentService;
    }

    @GetMapping
    public List<KnowledgeDocument> list(@PathVariable Long knowledgeBaseId,
                                        @RequestParam(required = false) String title) {
        return knowledgeDocumentService.findByKnowledgeBaseId(knowledgeBaseId, title);
    }

    @GetMapping("/search")
    public List<KnowledgeDocument> search(@PathVariable Long knowledgeBaseId,
                                          @RequestParam String keyword) {
        return knowledgeDocumentService.search(knowledgeBaseId, keyword);
    }

    @PostMapping
    public ResponseEntity<Void> create(@PathVariable Long knowledgeBaseId,
                                       @RequestBody CreateKnowledgeDocumentRequest request) {
        knowledgeDocumentService.create(knowledgeBaseId, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleInvalidRequest(IllegalArgumentException exception) {
        return ResponseEntity.badRequest().body(Map.of("error", exception.getMessage()));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(NoSuchElementException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", exception.getMessage()));
    }
}
