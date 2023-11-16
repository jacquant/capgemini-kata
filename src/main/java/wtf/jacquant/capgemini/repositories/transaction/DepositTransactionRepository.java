package wtf.jacquant.capgemini.repositories.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import wtf.jacquant.capgemini.domains.DepositTransaction;

public interface DepositTransactionRepository extends JpaRepository<DepositTransaction, Long> {
}