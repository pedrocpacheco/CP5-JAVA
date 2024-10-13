# Diploma API

## Integrantes
- Gabriel Amancio | RM 97936
- Pedro Pacheco | RM 98043
- Tomaz Pecoraro | RM RM 98499

## Descrição
Esta API permite a gestão de diplomas, incluindo a criação e a recuperação de informações sobre diplomados e cursos.

## Como Rodar
1. Clone o repositório
2. Configure o banco de dados no `application.properties`
3. Execute a aplicação com `mvn spring-boot:run`

## Endpoints
- **POST /auth/login** - Login
- **POST /auth/register** - Registro
- **GET /diplomas/{id}** - Recupera o diploma
