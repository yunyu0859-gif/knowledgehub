package com.example.knowledgehub.mapper;

import com.example.knowledgehub.model.KnowledgeBase;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface KnowledgeBaseMapper {

    @Select("SELECT id, name, description, created_at FROM knowledge_base ORDER BY id DESC")
    @ConstructorArgs({
        @Arg(column = "id", javaType = Long.class, id = true),
        @Arg(column = "name", javaType = String.class),
        @Arg(column = "description", javaType = String.class),
        @Arg(column = "created_at", javaType = LocalDateTime.class)
    })
    List<KnowledgeBase> findAll();

    @Insert("INSERT INTO knowledge_base (name, description) VALUES (#{name}, #{description})")
    int insert(
        @Param("name") String name,
        @Param("description") String description
    );
}
