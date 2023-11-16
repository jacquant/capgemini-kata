package wtf.jacquant.capgemini.repositories.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import wtf.jacquant.capgemini.domains.AccountTransaction;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
}