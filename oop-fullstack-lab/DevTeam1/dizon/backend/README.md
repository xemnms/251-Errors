# Product Lab Backend

## Requirements

- Java 17 or newer
- Maven 3.9 or newer
- PostgreSQL running on `localhost:5432`

## Run PostgreSQL

From `oop-fullstack-lab/DevTeam1/dizon`:

```bash
docker compose up -d
```

## Run Backend

From `oop-fullstack-lab/DevTeam1/dizon/backend`:

```bash
mvn spring-boot:run
```

The API will run at:

```text
http://localhost:8080/api/products
```

## Endpoints

- `GET /api/products`
- `GET /api/products/{id}`
- `POST /api/products`
- `PUT /api/products/{id}`
- `DELETE /api/products/{id}`
