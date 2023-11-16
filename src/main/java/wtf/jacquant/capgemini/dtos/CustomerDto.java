package wtf.jacquant.capgemini.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import wtf.jacquant.capgemini.domains.Customer;
import wtf.jacquant.capgemini.dtos.AccountDto;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link Customer}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class CustomerDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 0L;
    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal balance;
    private @NotNull Set<AccountDto> accounts;

}