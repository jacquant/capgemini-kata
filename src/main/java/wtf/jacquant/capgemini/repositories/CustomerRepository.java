package wtf.jacquant.capgemini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wtf.jacquant.capgemini.domains.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.accounts a LEFT JOIN FETCH a.inTransactions LEFT JOIN FETCH a.outTransactions WHERE c.id = ?1")
    Optional<Customer> findCustomerAndFetchAccountsAndTransactions(Long id);
}