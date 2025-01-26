# Web Services com Spring Boot e JPA

Este projeto é um sistema de exemplo que utiliza **Spring Boot** e **JPA/Hibernate** para implementar uma API RESTful com um modelo de domínio completo. Ele cobre os conceitos de CRUD, mapeamento JPA, tratamento de exceções e configuração de banco de dados H2 para testes.

## Objetivos
- Criar um projeto Spring Boot Java
- Implementar um modelo de domínio
- Estruturar camadas lógicas: Resource, Service e Repository
- Configurar um banco de dados de teste (H2)
- Povoar o banco de dados com dados iniciais
- Implementar operações CRUD (Create, Retrieve, Update, Delete)
- Realizar tratamento de exceções

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
- **Banco de dados H2**
- **Maven**
- **JPA/Hibernate**

## Estrutura do Projeto
O projeto segue uma arquitetura em camadas:

1. **Camada de Domínio (Domain):** Define as entidades e o modelo de negócio.
2. **Camada de Repositório (Repository):** Responsável pela interação com o banco de dados.
3. **Camada de Serviço (Service):** Contém a lógica de negócios.
4. **Camada de Recursos (Resource):** Controla as requisições HTTP (endpoints da API).

### Modelo de Domínio
O modelo de domínio inclui as seguintes entidades:
- **User**: Representa os usuários.
- **Order**: Representa os pedidos dos usuários, com status.
- **Category**: Representa categorias de produtos.
- **Product**: Representa os produtos.
- **OrderItem**: Relaciona pedidos e produtos com atributos adicionais (quantidade e preço).
- **Payment**: Representa o pagamento de um pedido.

## Configuração do Banco de Dados
O projeto utiliza o banco de dados em memória **H2** para testes. As configurações estão nos arquivos `application.properties` e `application-test.properties`.

### Dependências no `pom.xml`
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

### Configurações no `application-test.properties`
```properties
# Datasource
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## Funcionalidades Implementadas

### CRUD para Usuários
- **Inserir Usuário** (POST `/users`):
```json
{
 "name": "Bob Brown",
 "email": "bob@gmail.com",
 "phone": "977557755",
 "password": "123456"
}
```

- **Consultar Usuários** (GET `/users` e GET `/users/{id}`)
- **Atualizar Usuário** (PUT `/users/{id}`):
```json
{
 "name": "Bob Brown",
 "email": "bob@gmail.com",
 "phone": "977557755"
}
```
- **Excluir Usuário** (DELETE `/users/{id}`)

### Relacionamentos Entre Entidades
- **One-to-Many**: `User` ↔ `Order`
- **Many-to-Many**: `Product` ↔ `Category` (com `@JoinTable`)
- **Many-to-Many com Atributos Adicionais**: `Order` ↔ `Product` via `OrderItem`
- **One-to-One**: `Order` ↔ `Payment`

### Tratamento de Exceções
- **ResourceNotFoundException:** Para entidades não encontradas.
- **DatabaseException:** Para erros de integridade referencial.

### Cálculos
- **Subtotal:** Método na entidade `OrderItem`.
- **Total:** Método na entidade `Order` que soma os subtotais.

## Testes e Console H2
- Acesse o console H2 no caminho `/h2-console`.
- Para testar a API, utilize ferramentas como **Postman** ou **cURL**.

## Como Executar o Projeto
1. Clone o repositório:
```bash
git clone https://github.com/acenelio/workshop-springboot2-jpa.git
```

2. Navegue até o diretório do projeto:
```bash
cd workshop-springboot2-jpa
```

3. Execute o projeto com o Maven:
```bash
mvn spring-boot:run
```

4. Acesse a API em `http://localhost:8080`.

## Links Relacionados
- [Documentação do Spring Boot](https://spring.io/projects/spring-boot)
- [H2 Database](http://www.h2database.com/html/main.html)
- [JPA / Hibernate](https://hibernate.org/)

## Autor
- Baseado no repositório do professor [Nelio Alves](https://github.com/acenelio).

---

Se precisar de mais ajuda com o projeto, não hesite em perguntar!
