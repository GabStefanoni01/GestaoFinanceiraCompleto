# Gestão Financeira Pessoal

API REST para organização financeira pessoal, desenvolvida com Java 17 e Spring Boot.

## Funcionalidades
- Cadastro e login com JWT
- Recuperação de senha por e-mail
- Cadastro, consulta, edição e exclusão de contas
- Gestão de receitas e despesas
- Gestão de metas financeiras
- Isolamento dos registros por usuário autenticado
- Documentação interativa com Swagger UI

## Tecnologias
Java 17 · Spring Boot 3.4.5 · Spring Security · JWT · Spring Data JPA · MariaDB · Maven · springdoc OpenAPI

## Executar localmente
1. Configure as variáveis de ambiente abaixo.
2. Entre na pasta `backend`.
3. Execute `./mvnw spring-boot:run` (Windows: `mvnw.cmd spring-boot:run`).

## Variáveis de ambiente
| Variável | Descrição |
|---|---|
| `DATABASE_URL` | JDBC URL do MariaDB |
| `DATABASE_USERNAME` | Usuário do banco |
| `DATABASE_PASSWORD` | Senha do banco |
| `APP_JWT_SECRET` | Segredo aleatório com pelo menos 32 bytes |
| `APP_JWT_EXPIRATION_MS` | Validade do JWT em ms (padrão 24h) |
| `MAIL_HOST`, `MAIL_PORT` | Servidor SMTP e porta |
| `MAIL_USERNAME`, `MAIL_PASSWORD` | Credenciais SMTP |
| `APP_FRONTEND_BASE_URL` | URL da aplicação cliente |

Nunca versione senhas, tokens ou chaves. Como versões anteriores continham credenciais no arquivo de configuração, rotacione as credenciais expostas antes do deploy.

## Documentação
Após iniciar a aplicação:
- Swagger UI: `/swagger-ui/index.html`
- OpenAPI JSON: `/v3/api-docs`
- Health check: `/health`

## Fluxo de teste no Swagger
1. Faça cadastro em `POST /auth/register`.
2. Faça login em `POST /auth/login`.
3. Copie `accessToken` da resposta.
4. Clique em **Authorize** e informe o token sem o prefixo `Bearer `.
5. Teste contas, transações e metas. Os registros são vinculados ao usuário do token.

As rotas financeiras exigem JWT. A API não aceita `userId` enviado pelo cliente para definir o proprietário de um registro.
