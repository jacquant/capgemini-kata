package wtf.jacquant.capgemini.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import wtf.jacquant.capgemini.domains.DepositTransaction;
import wtf.jacquant.capgemini.domains.Transaction;
import wtf.jacquant.capgemini.repositories.transaction.DepositTransactionRepository;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TransactionServiceTest {

    @Mock
    private DepositTransactionRepository depositTransactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    void testCreateDeposit() {
        // Arrange
        BigDecimal amount = BigDecimal.TEN;
        when(depositTransactionRepository.save(any(DepositTransaction.class))).thenReturn(new DepositTransaction());
        // Act
        Transaction result = transactionService.createDeposit(amount);

        // Assert
        Assertions.assertNotNull(result);
        verify(depositTransactionRepository, times(1)).save(any(DepositTransaction.class));
    }
}