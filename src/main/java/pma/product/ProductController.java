package pma.product;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

/**
 * Contrato do serviço Product (catálogo de produtos).
 *
 * - O product-service implementa esta interface (ProductResource).
 * - Os outros serviços (ex.: Order) podem usar esta mesma interface como cliente Feign.
 */
@FeignClient(name = "product", url = "${pma.product.url:http://product:8080}")
public interface ProductController {

  /** Cria um produto. 201 com o produto criado; 400 se algum campo for inválido. */
  @PostMapping("/products")
  ResponseEntity<ProductOut> create(@Valid @RequestBody ProductIn in);

  /** 200 com todos os produtos (lista vazia se não houver nenhum). */
  @GetMapping("/products")
  ResponseEntity<List<ProductOut>> findAll();

  /** 200 com o produto; 404 se não existe. */
  @GetMapping("/products/{id}")
  ResponseEntity<ProductOut> findById(@PathVariable("id") String id);

  /** 204; 404 se não existe. */
  @DeleteMapping("/products/{id}")
  ResponseEntity<Void> delete(@PathVariable("id") String id);

  @GetMapping("/products/health-check")
  ResponseEntity<Void> healthCheck();

}
