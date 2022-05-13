package ru.belonogov.bank.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Data
public class TransactionRequest {

    private Long debitor;
    private Long creditor;
    @Positive
    private Long amount;
}
