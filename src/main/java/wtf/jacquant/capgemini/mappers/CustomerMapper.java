package wtf.jacquant.capgemini.mappers;

import org.mapstruct.*;
import wtf.jacquant.capgemini.configurations.MappingConfig;
import wtf.jacquant.capgemini.domains.Customer;
import wtf.jacquant.capgemini.dtos.AccountDto;
import wtf.jacquant.capgemini.dtos.CustomerDto;
import wtf.jacquant.capgemini.dtos.CustomerInfoDto;

import java.math.BigDecimal;
import java.util.List;

@Mapper(config = MappingConfig.class, uses = {AccountMapper.class})
public interface CustomerMapper {
    Customer toEntity(CustomerDto customerDto);

    @AfterMapping
    default void linkAccounts(@MappingTarget Customer customer) {
        customer.getAccounts().forEach(account -> account.setCustomer(customer));
    }

    @AfterMapping
    default void setBalance(@MappingTarget CustomerDto customer) {
        BigDecimal balance = customer.getAccounts().stream().map(AccountDto::amount).reduce(BigDecimal.ZERO, BigDecimal::add);
        customer.setBalance(balance);
    }

    CustomerDto toDto(Customer customer);

    CustomerInfoDto toInfoDto(Customer customer);

    List<CustomerInfoDto> toInfoDto(Iterable<Customer> customers);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate(CustomerDto customerDto, @MappingTarget Customer customer);
}