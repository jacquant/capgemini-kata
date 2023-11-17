package wtf.jacquant.capgemini.controllers.json.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountCreateRequest {

    @NotNull(message = "customerId is required")
    private Long customerId;

    @NotNull(message = "initialCredit is required")
    @Min(value = 0, message = "initialCredit must be greater than or equal to 0")
    private BigDecimal initialCredit;
}
