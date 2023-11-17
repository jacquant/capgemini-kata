package wtf.jacquant.capgemini.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wtf.jacquant.capgemini.domains.Account;
import wtf.jacquant.capgemini.domains.Customer;
import wtf.jacquant.capgemini.dtos.AccountDto;
import wtf.jacquant.capgemini.dtos.CustomerDto;
import wtf.jacquant.capgemini.exceptions.CustomerNotFoundException;
import wtf.jacquant.capgemini.mappers.AccountMapper;
import wtf.jacquant.capgemini.mappers.CustomerMapper;
import wtf.jacquant.capgemini.repositories.CustomerRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final AccountMapper accountMapper;

    private final AccountService accountService;

    public CustomerDto getCustomer(final Long customerId) {
        return customerMapper.toDto(getCustomerById(customerId));
    }

    private Customer getCustomerById(final Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));
    }

    public CustomerDto createCustomer(final String firstName, final String lastName) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        return customerMapper.toDto(customerRepository.save(customer));
    }

    public AccountDto createAccount(final Long customerId, final BigDecimal initialAmount) {
        Customer customer = getCustomerById(customerId);
        Account account = accountService.createAccount(initialAmount);
        customer.addAccount(account);
        return accountMapper.toDto(account);
    }

}
