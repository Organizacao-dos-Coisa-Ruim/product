package pma.product;

import java.math.BigDecimal;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;

/**
 * Dados para criar um produto, no formato do enunciado do curso:
 * {"name": "Tomato", "price": 10.12, "unit": "kg"}.
 *
 * Os limites batem com as colunas da migration (tx_name VARCHAR(256), price NUMERIC(19, 2),
 * tx_unit VARCHAR(32)): valor fora deles vira 400, e não erro 500 no banco.
 */
@Builder
public record ProductIn(

    @NotBlank @Size(max = 256) String name,
    /** Preço em reais (a conversão para outras moedas é papel do Exchange). */
    @NotNull @Positive @Digits(integer = 17, fraction = 2) BigDecimal price,
    /** Unidade de venda: "kg", "un", "slice"... */
    @NotBlank @Size(max = 32) String unit

) {

}
