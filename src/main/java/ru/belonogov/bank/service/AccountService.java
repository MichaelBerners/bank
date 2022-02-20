package ru.belonogov.bank.service;

import ru.belonogov.bank.exception.AccountNumberNotFound;
import ru.belonogov.bank.models.Account;

import java.nio.channels.AcceptPendingException;

public interface AccountService {

    void create(Account account);

    Account read(Long id);

    Account readAccountNumber(Long number) throws AccountNumberNotFound;

    boolean update(Long id, Account account);




}
