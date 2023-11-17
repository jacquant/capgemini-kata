package wtf.jacquant.capgemini.config;


import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import wtf.jacquant.capgemini.mappers.*;

@TestConfiguration
public class MappersConfig {

    @Bean
    public TransactionMapper transactionMapper() {
        return new TransactionMapperImpl();
    }

    @Bean
    public AccountMapper accountMapper() {
        return new AccountMapperImpl();
    }

    @Bean
    public CustomerMapper customerMapper() {
        return new CustomerMapperImpl();
    }
}
