package ru.belonogov.bank.service;

import ru.belonogov.bank.exception.TransactionException;

public interface TransactionService {

    void transaction(Long debitor, Long kreditor, Long amount) throws Exception;
}
