package com.example.knowledgehub.controller;

import com.example.knowledgehub.model.KnowledgeBase;
import com.example.knowledgehub.service.KnowledgeBaseService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/knowledge-bases")
public class KnowledgeBaseController {

    private final KnowledgeBaseService knowledgeBaseService;

    public KnowledgeBaseController(KnowledgeBaseService knowledgeBaseService) {
        this.knowledgeBaseService = knowledgeBaseService;
    }

    @GetMapping
    public List<KnowledgeBase> list() {
        return knowledgeBaseService.findAll();
    }
}