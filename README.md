# product

Biblioteca de contrato do microsserviço Product: DTOs (`ProductIn` / `ProductOut`) e a
interface HTTP/Feign (`ProductController`) compartilhados entre os consumidores (ex.: Order)
e o `product-service`.

## Contrato

Formato do enunciado do curso: `{"id", "name", "price", "unit"}`, com `price` em reais e
`unit` sendo a unidade de venda (`kg`, `un`, `slice`...). O Order consome `GET /products/{id}`
e usa `id`, `name` e `price`.

| Método | Rota | Resposta |
|--------|------|----------|
| `POST` | `/products` | `201` + `ProductOut` + header `Location` · `400` campo inválido |
| `GET` | `/products` | `200` + lista de `ProductOut` (ordenada por nome) |
| `GET` | `/products/{id}` | `200` + `ProductOut` · `404` não existe |
| `DELETE` | `/products/{id}` | `204` · `404` não existe |
| `GET` | `/products/health-check` | `200` |

Validação do `ProductIn` (Bean Validation, via `@Valid` na interface):

- `name`: obrigatório, até 256 caracteres;
- `price`: obrigatório, maior que zero, no máximo 2 casas decimais;
- `unit`: obrigatório, até 32 caracteres.

```bash
# Instale antes de compilar o product-service
./mvnw clean install
```
