# KnowledgeHub AI

用于练习 Java 后端与 AI 应用开发的智能知识库项目。

## Day 1

- Spring Boot 4.2.0、Java 21、Maven 项目骨架
- `db/schema.sql`：知识库和文档两张表
- `python/day1_hello.py`：Python 入门程序

启动 Java 项目：

```powershell
./mvnw.cmd spring-boot:run
```

MySQL 服务启动后，用具备建库权限的账号执行 `db/schema.sql`。不要把数据库密码提交到仓库。

目前只搭建项目和表结构，接口及 AI 功能将在后续步骤开发。
