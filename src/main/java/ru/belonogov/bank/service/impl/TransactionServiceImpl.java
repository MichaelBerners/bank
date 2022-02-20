package ru.belonogov.bank.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.belonogov.bank.exception.TransactionException;
import ru.belonogov.bank.models.Account;
import ru.belonogov.bank.models.Transaction;
import ru.belonogov.bank.repositry.TransactionRepository;
import ru.belonogov.bank.service.AccountService;
import ru.belonogov.bank.service.TransactionService;
import javax.transaction.Transactional;
import java.sql.Timestamp;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    TransactionRepository transactionRepository;

    AccountService accountService;

    //Transaction transaction;

    @Transactional
    @Override
    public void transaction(Long a, Long b, Long amount) throws Exception {
            Account debitor = accountService.readAccountNumber(a);
            Account kreditor = accountService.readAccountNumber(b);

            if(debitor.getAmount() < amount || amount < 0){
                throw new TransactionException();
            }

            debitor.setAmount(debitor.getAmount() - amount);
            kreditor.setAmount(kreditor.getAmount() + amount);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            accountService.create(debitor);
            accountService.create(kreditor);

            Transaction transaction = new Transaction();
            transaction.setDebitor(debitor);
            transaction.setKreditor(kreditor);
            transaction.setAmount(amount);
            transaction.setDate(timestamp);
            transactionRepository.save(transaction);
    }
}
