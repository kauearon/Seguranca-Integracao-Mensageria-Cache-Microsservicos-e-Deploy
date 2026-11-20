# Segurança, Integração, Mensageria, Cache, Microsserviços e Deploy

API desenvolvida com **Spring Boot** abordando:
- **Segurança Stateless com JWT** (OAuth2 Resource Server, escopos, CORS por profile e documentação OpenAPI/Swagger)
- **Integração HTTP** (`RestClient`)
- **Cache** com **Caffeine** (`@Cacheable`, TTL e limite de entradas)
- **Mensageria** assíncrona com **RabbitMQ** (`@RabbitListener` e conversão JSON)
- **Testes de Integração** com **Testcontainers** e MySQL
- **Containerização e Deploy** com multi-stage `Dockerfile` e `compose.yaml` (API + MySQL + RabbitMQ)
