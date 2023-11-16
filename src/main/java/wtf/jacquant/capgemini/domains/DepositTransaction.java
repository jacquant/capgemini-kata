package wtf.jacquant.capgemini.domains;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("DEPOSIT")
public class DepositTransaction extends Transaction {
}