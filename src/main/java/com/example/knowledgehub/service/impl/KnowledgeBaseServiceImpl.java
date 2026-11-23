package com.example.knowledgehub.service.impl;

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
}
