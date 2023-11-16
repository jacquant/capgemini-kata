package wtf.jacquant.capgemini.mappers;

import org.mapstruct.*;
import wtf.jacquant.capgemini.configurations.MappingConfig;
import wtf.jacquant.capgemini.domains.Account;
import wtf.jacquant.capgemini.dtos.AccountDto;

@Mapper(config = MappingConfig.class, uses = {TransactionMapper.class})
public interface AccountMapper {
    Account toEntity(AccountDto accountDto);

    @AfterMapping
    default void linkInTransactions(@MappingTarget Account account) {
        account.getInTransactions().forEach(inTransaction -> inTransaction.setTarget(account));
    }

    @AfterMapping
    default void linkOutTransactions(@MappingTarget Account account) {
        account.getOutTransactions().forEach(outTransaction -> outTransaction.setSource(account));
    }

    AccountDto toDto(Account account);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Account partialUpdate(AccountDto accountDto, @MappingTarget Account account);
}