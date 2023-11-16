package wtf.jacquant.capgemini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import wtf.jacquant.capgemini.domains.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}