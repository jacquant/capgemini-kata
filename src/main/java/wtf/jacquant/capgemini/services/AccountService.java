package wtf.jacquant.capgemini.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wtf.jacquant.capgemini.domains.Account;
import wtf.jacquant.capgemini.domains.Transaction;
import wtf.jacquant.capgemini.repositories.AccountRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;
    private final TransactionService transactionService;

    Account createAccount(final BigDecimal initialAmount) {
        Account account = new Account();
        account.setAmount(initialAmount);

        if (initialAmount != null && initialAmount.compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = transactionService.createDeposit(initialAmount);
            account.addInTransaction(transaction);
        }
        return accountRepository.save(account);
    }

}
