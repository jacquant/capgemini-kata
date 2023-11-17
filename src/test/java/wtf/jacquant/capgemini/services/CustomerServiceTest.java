package wtf.jacquant.capgemini.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import wtf.jacquant.capgemini.config.MappersConfig;
import wtf.jacquant.capgemini.domains.Account;
import wtf.jacquant.capgemini.domains.Customer;
import wtf.jacquant.capgemini.dtos.AccountDto;
import wtf.jacquant.capgemini.dtos.CustomerDto;
import wtf.jacquant.capgemini.dtos.CustomerInfoDto;
import wtf.jacquant.capgemini.mappers.AccountMapper;
import wtf.jacquant.capgemini.mappers.CustomerMapper;
import wtf.jacquant.capgemini.repositories.CustomerRepository;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@Import(MappersConfig.class)
public class CustomerServiceTest {

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Mock
    private AccountService accountService;

    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService(customerRepository, customerMapper, accountMapper, accountService);
    }

    @Test
    void testListCustomers() {
        // Arrange
        Customer customer1 = new Customer();
        customer1.setId(1L);
        Customer customer2 = new Customer();
        customer2.setId(2L);
        when(customerRepository.findAll()).thenReturn(java.util.List.of(customer1, customer2));

        // Act
        List<CustomerInfoDto> result = customerService.listCustomers();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals(2L, result.get(1).getId());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void testGetCustomer() {
        // Arrange
        Long customerId = 1L;
        Customer customer = new Customer();
        when(customerRepository.findById(customerId)).thenReturn(java.util.Optional.of(customer));

        // Act
        CustomerDto result = customerService.getCustomer(customerId);

        // Assert
        assertNotNull(result);
        verify(customerRepository, times(1)).findById(customerId);
    }

    @Test
    void testCreateCustomer() {
        // Arrange
        String firstName = "John";
        String lastName = "Doe";
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        // Act
        CustomerDto result = customerService.createCustomer(firstName, lastName);

        // Assert
        assertNotNull(result);
        assertEquals(firstName, customer.getFirstName());
        assertEquals(lastName, customer.getLastName());
        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    void testCreateAccount() {
        // Arrange
        Long customerId = 1L;
        BigDecimal initialAmount = BigDecimal.TEN;
        Customer customer = new Customer();
        Account account = new Account();
        when(customerRepository.findById(customerId)).thenReturn(java.util.Optional.of(customer));
        when(accountService.createAccount(initialAmount)).thenReturn(account);

        // Act
        AccountDto result = customerService.createAccount(customerId, initialAmount);

        // Assert
        assertNotNull(result);
        verify(customerRepository, times(1)).findById(customerId);
        verify(accountService, times(1)).createAccount(initialAmount);
    }
}
