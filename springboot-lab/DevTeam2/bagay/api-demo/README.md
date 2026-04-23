# Bagay Spring Boot API Demo

This is my Spring Boot lab project for the `/me` REST endpoint.

## Endpoint

- `GET /me`
- Returns JSON with my basic student information.

## Example Response

```json
{
  "name": "Axel Drake M. Bagay",
  "studentId": "2025-1020735",
  "course": "Java Programming",
  "message": "Learning Spring Boot REST APIs!"
}
```

## Run

```powershell
./mvnw spring-boot:run
```

## Test

```powershell
./mvnw test
```

## Retrospective Improvements

1. Add validation and global exception handling for cleaner API error responses.
2. Return a typed DTO class instead of a raw `Map<String, Object>` for stronger maintainability.

