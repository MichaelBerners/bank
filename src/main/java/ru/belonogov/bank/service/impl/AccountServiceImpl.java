package ru.belonogov.bank.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.belonogov.bank.domain.exception.AccountNumberNotFound;
import ru.belonogov.bank.domain.entity.Account;
import ru.belonogov.bank.domain.repositry.AccountRepository;
import ru.belonogov.bank.service.AccountService;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
       return accountRepository.save(account);
    }

    @Override
    public Account read(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }


    @Override
    public Account findByAccountNumber(Long number) {
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
