# OOP Full-Stack Lab: Product Manager

This project is a full-stack CRUD application using React, TypeScript, Spring Boot, Spring Data JPA, and PostgreSQL.

## Folder Structure

```text
oop-fullstack-lab/
`-- DevTeam1/
    `-- dizon/
        |-- backend/
        |-- frontend/
        |-- evidence/
        |-- CHANGELOG.md
        |-- PERSONAL.md
        |-- PEER_FEEDBACK.md
        `-- docker-compose.yml
```

## OOP Concepts Used

- Encapsulation: React component state and private Java entity fields.
- Abstraction: `productService` hides frontend API calls; `ProductRepository` hides database queries.
- Polymorphism: `ProductRepository` extends `JpaRepository`.
- Separation of concerns: UI components, API service, controller, service, repository, entity, and DTOs are separated.

## Run Order

1. Start PostgreSQL:

```bash
docker compose up -d
```

2. Start backend:

```bash
cd backend
mvn spring-boot:run
```

3. Start frontend in another terminal:

```bash
cd frontend
npm install
npm run dev
```

4. Open:

```text
http://localhost:5173
```

## Bonus Features

- DTOs: `ProductRequest` and `ProductResponse`
- Validation: Jakarta Bean Validation on request DTOs
- Error handling: `GlobalExceptionHandler`
- Better UI styling: Responsive styled product dashboard
- Loading states: Skeleton list and button loading text
