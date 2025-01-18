# Challenge Forum Hub 🌐

Bem-vindo ao **Challenge Forum Hub**, uma API para gerenciamento de usuários e tópicos. Este projeto foi desenvolvido como parte do Challenge Forum Hub, integrado à formação em programação da Alura na trilha ONE 7 - Oracle Next Education.

## Funcionalidades ⚙️

### Usuários:
- **Cadastro de novos usuários**: Permite que novos usuários se registrem na plataforma. 🆕
- **Atualização de informações do usuário**: Altera as informações de um usuário existente. 🔄
- **Exibição de detalhes de um usuário**: Recupera as informações detalhadas de um usuário. 📄
- **Exclusão de um usuário**: Permite a remoção de um usuário da plataforma. ❌

### Tópicos:
- **Criação de novos tópicos**: Usuários podem criar tópicos de discussão. 💬
- **Atualização de tópicos existentes**: Modifica tópicos já criados. ✍️
- **Exibição de detalhes de um tópico**: Visualiza as informações detalhadas de um tópico. 📑
- **Exclusão de um tópico**: Apaga um tópico existente. 🗑️
- **Listagem de tópicos com paginação**: Exibe os tópicos de forma paginada. 📜

### Autenticação:
- **Login de usuários autenticados**: Permite que os usuários se autentiquem no sistema. 🔑

## Tecnologias Utilizadas 🖥️
- **Spring Boot**: Framework utilizado para construção da aplicação. 🚀
- **Spring Security**: Para segurança e autenticação de usuários. 🔒
- **JPA (Java Persistence API)**: Para persistência de dados no banco. 🗄️
- **Swagger UI**: Para visualização e testes da API. 🌐
- **MySQL**: Banco de dados utilizado, com migrations personalizadas. 💾
- **Flyway**: Para gerenciamento de versões do banco de dados. 🛠️
- **JWT (JSON Web Token)**: Para autenticação e segurança de requisições. 🔐
- **OpenAPI 3.1.0**: Para documentação da API. 📖
- **ChatGPT**: Otimizando os resultados e auxiliando no desenvolvimento. 🤖

## Endpoints da API 🚪

### 1. Usuários
- **POST /user/register**: Cadastra um novo usuário. 📝
- **PUT /user/{id}/update**: Atualiza as informações de um usuário. 🔄
- **GET /user/{id}/details**: Obtém os detalhes de um usuário. 📄
- **DELETE /user/{id}/delete**: Exclui um usuário. ❌

### 2. Tópicos
- **POST /topics/create**: Cria um novo tópico. 🆕
- **PUT /topics/{id}/update**: Atualiza um tópico existente. ✍️
- **GET /topics/{id}/details**: Obtém os detalhes de um tópico. 📑
- **DELETE /topics/{id}/delete**: Exclui um tópico. 🗑️
- **GET /topics/list**: Lista todos os tópicos com suporte a paginação. 📜

### 3. Autenticação
- **POST /auth**: Realiza o login de um usuário. 🔑

## Filtros de Segurança 🛡️

- **Filtro de Autorização para Usuários**: Garante que um usuário só possa acessar ou modificar dados relacionados ao seu próprio perfil. Ele valida o `user_id` presente na URL da requisição, negando o acesso se o ID não corresponder ao usuário autenticado.

- **Filtro de Autorização para Tópicos**: Assegura que apenas o autor de um tópico possa realizar ações como atualizar ou deletar o tópico. Ele valida se o usuário autenticado é o responsável pelo tópico.

## Requisitos ⚙️
- **Java 17 ou superior**: Para execução da aplicação. ☕
- **MySQL**: Para banco de dados e migrações personalizadas. 💾

## Como Executar o Projeto 🚀

### Passos para Rodar
1. **Clone o repositório**:

    ```bash
    git clone https://github.com/seu-usuario/forumhub.git
    cd forumhub
    ```

2. **Instale as dependências**:

    ```bash
    mvn install
    ```

3. **Execute o aplicativo**:

    ```bash
    mvn spring-boot:run
    ```

A API estará disponível em `http://localhost:8080`.

## Testar a API 🧪
Você pode testar a API diretamente usando o Swagger UI (disponível em `http://localhost:8080/swagger-ui`) ou ferramentas como Postman.

## Contribuições 💡
Contribuições são bem-vindas! Se você quiser melhorar ou corrigir o código, sinta-se à vontade para abrir um pull request.

## Licença 📜
Este projeto está licenciado sob a Licença MIT - veja o arquivo LICENSE para mais detalhes.

**Desenvolvido por**: Kaio Victor
