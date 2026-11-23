package com.example.knowledgehub.service.impl;

import com.example.knowledgehub.dto.CreateKnowledgeBaseRequest;
import com.example.knowledgehub.mapper.KnowledgeBaseMapper;
import com.example.knowledgehub.model.KnowledgeBase;
import com.example.knowledgehub.service.KnowledgeBaseService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class KnowledgeBaseServiceImpl implements KnowledgeBaseService {

    private final KnowledgeBaseMapper knowledgeBaseMapper;

    public KnowledgeBaseServiceImpl(KnowledgeBaseMapper knowledgeBaseMapper) {
        this.knowledgeBaseMapper = knowledgeBaseMapper;
    }

    @Override
    public List<KnowledgeBase> findAll() {
        return knowledgeBaseMapper.findAll();
    }

    @Override
    public void create(CreateKnowledgeBaseRequest request) {
        if (request == null || request.name() == null || request.name().isBlank()) {
            throw new IllegalArgumentException("知识库名称不能为空");
        }

        String name = request.name().trim();
        if (name.length() > 100) {
            throw new IllegalArgumentException("知识库名称不能超过100个字符");
        }

        String description = request.description() == null ? null : request.description().trim();
        if (description != null && description.length() > 500) {
            throw new IllegalArgumentException("知识库描述不能超过500个字符");
        }

        knowledgeBaseMapper.insert(name, description);
    }
}
