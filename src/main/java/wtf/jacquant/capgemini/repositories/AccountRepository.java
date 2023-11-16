package wtf.jacquant.capgemini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import wtf.jacquant.capgemini.domains.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}