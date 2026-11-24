# KnowledgeHub AI

用于练习 Java 后端与 AI 应用开发的智能知识库项目。

## 已实现

- Spring Boot 4.2.0、Java 21、Maven、MyBatis、MySQL
- 知识库新增与列表查询
- 知识库文档新增、列表查询、按标题筛选
- 文档标题和正文的关键词检索（最多返回 20 条）
- `db/schema.sql`：知识库和文档两张表
- `python/`：Python 入门练习

MySQL 服务启动后，用具备建库权限的账号执行 `db/schema.sql`。启动 Java 项目前设置本机的 `DB_PASSWORD` 环境变量，不要把密码提交到仓库。

启动 Java 项目（PowerShell）：

```powershell
$env:DB_PASSWORD = "你的本机 MySQL 密码"
.\mvnw.cmd spring-boot:run
```

## 接口

| 方法 | 路径 | 功能 |
| --- | --- | --- |
| GET | `/api/knowledge-bases` | 查询知识库列表 |
| POST | `/api/knowledge-bases` | 创建知识库 |
| GET | `/api/knowledge-bases/{id}/documents` | 查询文档，可选 `title` 参数 |
| POST | `/api/knowledge-bases/{id}/documents` | 创建文档 |
| GET | `/api/knowledge-bases/{id}/documents/search?keyword=Spring` | 搜索文档标题和正文 |

新增接口成功时返回 HTTP 201，响应体为空。搜索结果为空时返回 `[]`，知识库 ID 不存在时返回 HTTP 404，关键词为空时返回 HTTP 400。

当前检索是 MySQL 关键词匹配，用于给未来的 Agent 提供资料查询能力。大模型、向量检索和 Agent 尚未接入。
