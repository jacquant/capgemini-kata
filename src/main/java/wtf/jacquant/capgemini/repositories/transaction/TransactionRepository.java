package wtf.jacquant.capgemini.repositories.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import wtf.jacquant.capgemini.domains.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}