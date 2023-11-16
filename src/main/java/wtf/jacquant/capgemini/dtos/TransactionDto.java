package wtf.jacquant.capgemini.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link wtf.jacquant.capgemini.domains.Transaction}
 */
public record TransactionDto(Long id, Long sourceId, Long targetId, BigDecimal amount, Instant createdDate) implements Serializable {
}