package ru.belonogov.bank.service;

import ru.belonogov.bank.domain.TransactionRequest;
import ru.belonogov.bank.domain.TransactionResponse;

public interface TransactionService {

    TransactionResponse transaction(TransactionRequest transactionRequest);
}
