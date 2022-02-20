package ru.belonogov.bank.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.belonogov.bank.exception.AccountNumberNotFound;
import ru.belonogov.bank.models.Account;
import ru.belonogov.bank.repositry.AccountRepository;
import ru.belonogov.bank.service.AccountService;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;

    @Override
    public void create(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account read(Long id) {
        return accountRepository.findById(id).orElseThrow();
    }


    @Override
    public Account readAccountNumber(Long number) throws AccountNumberNotFound {
        return accountRepository.findAccountByAccountNumber(number)
                .orElseThrow(() -> new AccountNumberNotFound());
        //return accountRepository.readAccountNumber(number);
    }

    @Override
    public boolean update(Long id, Account account) {
        if (accountRepository.existsById(id)) {
            account.setId(id);
            accountRepository.save(account);
            return true;
        }

        else return false;
    }

}
