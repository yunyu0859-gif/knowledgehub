package com.example.knowledgehub.service.impl;

import com.example.knowledgehub.dto.CreateKnowledgeDocumentRequest;
import com.example.knowledgehub.mapper.KnowledgeBaseMapper;
import com.example.knowledgehub.mapper.KnowledgeDocumentMapper;
import com.example.knowledgehub.model.KnowledgeDocument;
import com.example.knowledgehub.service.KnowledgeDocumentService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class KnowledgeDocumentServiceImpl implements KnowledgeDocumentService {

    private final KnowledgeBaseMapper knowledgeBaseMapper;
    private final KnowledgeDocumentMapper knowledgeDocumentMapper;

    public KnowledgeDocumentServiceImpl(KnowledgeBaseMapper knowledgeBaseMapper,
                                        KnowledgeDocumentMapper knowledgeDocumentMapper) {
        this.knowledgeBaseMapper = knowledgeBaseMapper;
        this.knowledgeDocumentMapper = knowledgeDocumentMapper;
    }

    @Override
    public List<KnowledgeDocument> findByKnowledgeBaseId(Long knowledgeBaseId, String title) {
        requireKnowledgeBase(knowledgeBaseId);
        String searchTitle = title == null || title.isBlank() ? null : title.trim();
        if (searchTitle != null && searchTitle.length() > 200) {
            throw new IllegalArgumentException("搜索标题不能超过200个字符");
        }
        return knowledgeDocumentMapper.findByKnowledgeBaseId(knowledgeBaseId, searchTitle, null);
    }

    @Override
    public List<KnowledgeDocument> search(Long knowledgeBaseId, String keyword) {
        requireKnowledgeBase(knowledgeBaseId);
        if (keyword == null || keyword.isBlank()) {
            throw new IllegalArgumentException("搜索关键词不能为空");
        }
        String searchKeyword = keyword.trim();
        if (searchKeyword.length() > 100) {
            throw new IllegalArgumentException("搜索关键词不能超过100个字符");
        }
        return knowledgeDocumentMapper.findByKnowledgeBaseId(knowledgeBaseId, null, searchKeyword);
    }

    @Override
    public void create(Long knowledgeBaseId, CreateKnowledgeDocumentRequest request) {
        requireKnowledgeBase(knowledgeBaseId);
        if (request == null || request.title() == null || request.title().isBlank()) {
            throw new IllegalArgumentException("文档标题不能为空");
        }
        String title = request.title().trim();
        if (title.length() > 200) {
            throw new IllegalArgumentException("文档标题不能超过200个字符");
        }
        if (request.content() == null || request.content().isBlank()) {
            throw new IllegalArgumentException("文档内容不能为空");
        }
        knowledgeDocumentMapper.insert(knowledgeBaseId, title, request.content().trim());
    }

    private void requireKnowledgeBase(Long knowledgeBaseId) {
        if (knowledgeBaseId == null || knowledgeBaseId <= 0 || knowledgeBaseMapper.countById(knowledgeBaseId) == 0) {
            throw new NoSuchElementException("知识库不存在");
        }
    }
}
