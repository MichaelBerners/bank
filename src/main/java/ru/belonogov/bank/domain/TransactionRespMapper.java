package ru.belonogov.bank.domain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.belonogov.bank.domain.entity.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionRespMapper {

    @Mappings({
            @Mapping(target="creditorId", source = "transaction.kreditor.id"),
            @Mapping(target="debitorId", source = "transaction.debitor.id")
            //@Mapping(source = "id", ignore = true)
    })
    TransactionResponse toTransactionResp(Transaction transaction);
}
