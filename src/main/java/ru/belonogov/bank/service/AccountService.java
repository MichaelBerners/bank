package ru.belonogov.bank.service;

import ru.belonogov.bank.domain.exception.AccountNumberNotFound;
import ru.belonogov.bank.domain.entity.Account;

public interface AccountService {

    void save(Account account);

    Account read(Long id); //findById

    Account findByAccountNumber(Long number) throws AccountNumberNotFound;

    boolean update(Long id, Account account);




}
