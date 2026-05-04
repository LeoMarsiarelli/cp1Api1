# CP1 API 1 - Cinema (Filmes & Salas)

API RESTful em Spring Boot que persiste dados de **Filmes** e **Salas** de um cinema em um banco MySQL via Spring Data JPA.

Projeto referente ao Checkpoint 2 da disciplina **SOA - Microservices and Web Engineering** (FIAP, 1º semestre / 2026).

## Stack

- Java 25
- Spring Boot 4.0.3 (Web MVC + Spring Data JPA)
- MySQL 8
- springdoc-openapi (Swagger UI)
- Maven
- Docker / Docker Compose

## Entidades

### Filme (`filmes`)

| Atributo         | Tipo    | Nullable |
|------------------|---------|----------|
| id               | Long    | não (PK) |
| titulo           | String  | não      |
| diretor          | String  | não      |
| anoLancamento    | Integer | não      |
| duracaoMinutos   | Integer | não      |
| genero           | String  | **sim**  |

### Sala (`salas`)

| Atributo    | Tipo    | Nullable |
|-------------|---------|----------|
| id          | Long    | não (PK) |
| numero      | Integer | não      |
| capacidade  | Integer | não      |
| andar       | Integer | não      |
| acessivel   | Boolean | não      |
| tipo        | String  | **sim**  |

## Como rodar

### 1. Subir o banco com Docker

Na raiz do projeto:

```bash
docker compose up -d
```

Alternativa, sem `docker-compose.yml`:

```bash
docker run --name cp1api1-mysql \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=cp1api1 \
  -e MYSQL_USER=cp1user \
  -e MYSQL_PASSWORD=cp1pass \
  -p 3306:3306 \
  -d mysql:8.0
```

O banco fica disponível em `localhost:3306`, com:

- Database: `cp1api1`
- Usuário: `cp1user`
- Senha: `cp1pass`

Essas credenciais já estão configuradas em `src/main/resources/application.properties`.

### 2. Subir a API

```bash
./mvnw spring-boot:run
```

Ou (Windows):

```bash
mvnw.cmd spring-boot:run
```

A API sobe na porta **8080**.

### 3. Documentação (Swagger)

[http://localhost:8080/](http://localhost:8080/)

## Endpoints

### Filmes (`/filmes`)

| Método | Rota             | Descrição            |
|--------|------------------|----------------------|
| GET    | `/filmes`        | findAll              |
| GET    | `/filmes/{id}`   | findById             |
| POST   | `/filmes`        | Cria um filme        |
| PUT    | `/filmes/{id}`   | Atualiza um filme    |
| DELETE | `/filmes/{id}`   | Remove um filme      |

Exemplo de body (POST/PUT):

```json
{
  "titulo": "Inception",
  "diretor": "Christopher Nolan",
  "anoLancamento": 2010,
  "duracaoMinutos": 148,
  "genero": "Ficção Científica"
}
```

### Salas (`/salas`)

| Método | Rota             | Descrição            |
|--------|------------------|----------------------|
| GET    | `/salas`         | findAll              |
| GET    | `/salas/{id}`    | findById             |
| POST   | `/salas`         | Cria uma sala        |
| PUT    | `/salas/{id}`    | Atualiza uma sala    |
| DELETE | `/salas/{id}`    | Remove uma sala      |

Exemplo de body (POST/PUT):

```json
{
  "numero": 1,
  "capacidade": 120,
  "andar": 2,
  "acessivel": true,
  "tipo": "IMAX"
}
```

## Parar o banco

```bash
docker compose down
```
