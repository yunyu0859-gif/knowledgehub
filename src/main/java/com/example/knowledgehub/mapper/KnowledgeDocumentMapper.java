package com.example.knowledgehub.mapper;

import com.example.knowledgehub.model.KnowledgeDocument;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface KnowledgeDocumentMapper {

    @Select({
        "<script>",
        "SELECT id, knowledge_base_id, title, content, created_at",
        "FROM knowledge_document WHERE knowledge_base_id = #{knowledgeBaseId}",
        "<if test='title != null'>AND title LIKE CONCAT('%', #{title}, '%')</if>",
        "ORDER BY id DESC",
        "</script>"
    })
    @ConstructorArgs({
        @Arg(column = "id", javaType = Long.class, id = true),
        @Arg(column = "knowledge_base_id", javaType = Long.class),
        @Arg(column = "title", javaType = String.class),
        @Arg(column = "content", javaType = String.class),
        @Arg(column = "created_at", javaType = LocalDateTime.class)
    })
    List<KnowledgeDocument> findByKnowledgeBaseId(@Param("knowledgeBaseId") Long knowledgeBaseId,
                                                   @Param("title") String title);

    @Insert("INSERT INTO knowledge_document (knowledge_base_id, title, content) VALUES (#{knowledgeBaseId}, #{title}, #{content})")
    int insert(@Param("knowledgeBaseId") Long knowledgeBaseId,
               @Param("title") String title,
               @Param("content") String content);
}
