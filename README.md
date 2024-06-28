# Cadastro de Funcionários API

## Descrição

Esta é uma API RESTful para gerenciamento de funcionários, desenvolvida com Spring Boot. Ela permite realizar operações de CRUD (Criar, Ler, Atualizar, Deletar) em registros de funcionários. A aplicação usa PostgreSQL como banco de dados.

### Dependências Utilizadas

- Spring Boot
- Spring Data JPA
- PostgreSQL Driver
- Hibernate
- Spring Web

### Como Clonar o Repositório

```sh
git clone https://github.com/devleomarinho/api-cadastro-rh.git
```

### Pré-requisitos

- JDK 11 ou superior
- Maven
- IDE de sua preferência. Sugiro o IntelliJ IDEA

### Configuração do Banco de Dados
1. Crie um banco de dados PostgreSQL:
```sh
   CREATE DATABASE cadastro_funcionarios;
```

2. Configure as variáveis de ambiente no seu sistema ou crie um arquivo .env na raiz do projeto com as seguintes informações:

```sh
DATABASE_URL=jdbc:postgresql://localhost:5432/cadastro_funcionarios
DATABASE_USERNAME=seu_usuario
DATABASE_PASSWORD=sua_senha
```
3. Se preferir, configure o arquivo application.properties:
```sh
spring.datasource.url=jdbc:postgresql://localhost:5432/cadastro_funcionarios
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

### Executando a aplicação

Vá até o diretório raiz do projeto e digite:

```sh
mvnw spring-boot:run
```

## Endpoints disponíveis

- GET /api/funcionarios: Lista todos os funcionários
- GET /api/funcionarios/{id}: Busca um funcionário pelo ID
- POST /api/funcionarios: Cria um novo funcionário
- PUT /api/funcionarios/{id}: Atualiza um funcionário existente
- DELETE /api/funcionarios/{id}: Deleta um funcionário pelo ID

### Atributos básicos da classe POJO Funcionario


    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String cargo;
    private String departamento;
    private double salario;
    private double bonus;

## Licença
Este projeto está licenciado sob a Licença MIT - veja o arquivo LICENSE.md para detalhes.

## Autor
Leonardo Marinho - github.com/devleomarinho
