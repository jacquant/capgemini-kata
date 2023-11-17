package wtf.jacquant.capgemini.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wtf.jacquant.capgemini.domains.Customer;

import java.io.Serial;
import java.io.Serializable;

/**
 * DTO for {@link Customer}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class CustomerInfoDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 0L;
    private Long id;
    private String firstName;
    private String lastName;

}