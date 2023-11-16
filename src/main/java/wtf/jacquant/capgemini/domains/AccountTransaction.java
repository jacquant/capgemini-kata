package wtf.jacquant.capgemini.domains;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("ACCOUNT")
public class AccountTransaction extends Transaction {
}
