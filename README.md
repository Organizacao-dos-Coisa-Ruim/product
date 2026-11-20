# product

Biblioteca de contrato do microsserviço Product: DTOs (`ProductIn` / `ProductOut`) e a
interface HTTP/Feign (`ProductController`) compartilhados entre os consumidores (ex.: Order)
e o `product-service`.

O contrato (CRUD de produtos) é definido na issue #26. O Order já consome
`GET /products/{id}` esperando `id`, `name` e `price`.

```bash
# Instale antes de compilar o product-service
./mvnw clean install
```
