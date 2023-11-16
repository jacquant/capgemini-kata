package wtf.jacquant.capgemini.mappers;

import org.mapstruct.*;
import wtf.jacquant.capgemini.domains.Transaction;
import wtf.jacquant.capgemini.dtos.TransactionDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransactionMapper {
    Transaction toEntity(TransactionDto transactionDto);


    @Mapping(target = "sourceId", source = "source.id")
    @Mapping(target = "targetId", source = "target.id")
    TransactionDto toDto(Transaction transaction);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Transaction partialUpdate(TransactionDto transactionDto, @MappingTarget Transaction transaction);
}