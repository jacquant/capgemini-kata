package wtf.jacquant.capgemini.domains;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_gen")
    @SequenceGenerator(name = "account_gen", sequenceName = "account_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, precision = 5, scale = 3)
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "target")
    private Set<Transaction> inTransactions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "source")
    private Set<Transaction> outTransactions = new LinkedHashSet<>();

    public void addInTransaction(Transaction transaction) {
        inTransactions.add(transaction);
        transaction.setTarget(this);
    }

    public void removeInTransaction(Transaction transaction) {
        inTransactions.remove(transaction);
        transaction.setTarget(null);
    }

    public void addOutTransaction(Transaction transaction) {
        outTransactions.add(transaction);
        transaction.setSource(this);
    }

    public void removeOutTransaction(Transaction transaction) {
        outTransactions.remove(transaction);
        transaction.setSource(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        return id != null && id.equals(((Account) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}