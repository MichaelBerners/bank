package ru.belonogov.bank.service;

import ru.belonogov.bank.domain.exception.TransactionException;

public interface TransactionService {

    void transaction(Long debitor, Long kreditor, Long amount) throws Exception;
}
