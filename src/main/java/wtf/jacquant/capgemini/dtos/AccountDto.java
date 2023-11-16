package wtf.jacquant.capgemini.dtos;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * DTO for {@link wtf.jacquant.capgemini.domains.Account}
 */
public record AccountDto(@NotNull(message = "Id cannot be null") Long id,
                         @NotNull(message = "Amount cannot be null") BigDecimal amount,
                         Set<TransactionDto> inTransactions,
                         Set<TransactionDto> outTransactions) implements Serializable {
}