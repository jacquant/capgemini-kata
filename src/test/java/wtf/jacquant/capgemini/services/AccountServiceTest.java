package wtf.jacquant.capgemini.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import wtf.jacquant.capgemini.domains.Account;
import wtf.jacquant.capgemini.domains.Transaction;
import wtf.jacquant.capgemini.repositories.AccountRepository;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private AccountService accountService;

    @Test
    void testCreateAccountWithInitialAmount() {
        // Arrange
        BigDecimal initialAmount = BigDecimal.TEN;
        Account account = new Account();
        account.setAmount(initialAmount);
        Transaction transactionMock = new Transaction();
        transactionMock.setAmount(initialAmount);
        account.setInTransactions(Set.of(transactionMock));

        when(accountRepository.save(any(Account.class))).thenReturn(account);
        when(transactionService.createDeposit(initialAmount)).thenReturn(transactionMock);

        // Act
        Account result = accountService.createAccount(initialAmount);

        // Assert
        assertNotNull(result);
        assertEquals(initialAmount, result.getAmount());
        assertEquals(1, result.getInTransactions().size());
        assertTrue(result.getInTransactions().contains(transactionMock));

        verify(transactionService, times(1)).createDeposit(initialAmount);
        verify(accountRepository, times(1)).save(any(Account.class));
    }

    @Test
    void testCreateAccountWithoutInitialAmount() {
        // Arrange
        BigDecimal initialAmount = BigDecimal.ZERO;
        Account account = new Account();
        account.setAmount(initialAmount);
        Transaction transactionMock = new Transaction();
        transactionMock.setAmount(initialAmount);

        when(accountRepository.save(any(Account.class))).thenReturn(account);
        when(transactionService.createDeposit(initialAmount)).thenReturn(transactionMock);

        // Act
        Account result = accountService.createAccount(initialAmount);

        // Assert
        assertNotNull(result);
        assertEquals(initialAmount, result.getAmount());
        assertEquals(0, result.getInTransactions().size());

        verify(transactionService, times(0)).createDeposit(initialAmount);
        verify(accountRepository, times(1)).save(any(Account.class));
    }
}
