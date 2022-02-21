package ru.belonogov.bank.domain;

import javax.validation.constraints.Positive;

public class TransactionRequest {

    private Long debitor;

    private Long creditor;

    @Positive
    private Long amount;
}
