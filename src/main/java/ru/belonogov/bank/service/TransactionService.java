package ru.belonogov.bank.service;

import ru.belonogov.bank.domain.request.TransactionRequest;
import ru.belonogov.bank.domain.response.TransactionResponse;

public interface TransactionService {

    TransactionResponse transaction(TransactionRequest transactionRequest);
}
