CREATE DATABASE IF NOT EXISTS knowledgehub CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE knowledgehub;

CREATE TABLE IF NOT EXISTS knowledge_base (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '知识库ID',
    name VARCHAR(100) NOT NULL COMMENT '知识库名称',
    description VARCHAR(500) COMMENT '知识库描述',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) COMMENT='知识库';

CREATE TABLE IF NOT EXISTS knowledge_document (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '文档ID',
    knowledge_base_id BIGINT NOT NULL COMMENT '所属知识库ID',
    title VARCHAR(200) NOT NULL COMMENT '文档标题',
    content TEXT NOT NULL COMMENT '文档内容',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    CONSTRAINT fk_document_base FOREIGN KEY (knowledge_base_id) REFERENCES knowledge_base(id)
) COMMENT='知识库文档';
