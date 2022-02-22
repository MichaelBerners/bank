package ru.belonogov.bank.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.belonogov.bank.domain.TransactionRequest;
import ru.belonogov.bank.domain.TransactionRespMapper;
import ru.belonogov.bank.domain.TransactionResponse;
import ru.belonogov.bank.domain.exception.TransactionException;
import ru.belonogov.bank.domain.entity.Account;
import ru.belonogov.bank.domain.entity.Transaction;
import ru.belonogov.bank.domain.repositry.TransactionRepository;
import ru.belonogov.bank.service.AccountService;
import ru.belonogov.bank.service.TransactionService;
import javax.transaction.Transactional;
import java.sql.Timestamp;

@Slf4j
@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountService accountService;
    private final TransactionRespMapper transactionRespMapper;  //маппер Mapstruct

    @Transactional
    @Override
    public TransactionResponse transaction(final TransactionRequest transactionRequest) {
        final Account debitor = accountService.findByAccountNumber(transactionRequest.getDebitor());
        log.info("debit account found {}", debitor);
        final Account kreditor = accountService.findByAccountNumber(transactionRequest.getCreditor());

        final Long amount = transactionRequest.getAmount();

        if (debitor.getAmount() < amount) {
            throw new TransactionException();
        }

        debitor.setAmount(debitor.getAmount() - amount);
        kreditor.setAmount(kreditor.getAmount() + amount);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        final Account saveDebitor = accountService.save(debitor);
        //debitor = accountService.save(debitor); (не ок)
        final Account saveCreditor = accountService.save(kreditor);

        Transaction transaction = new Transaction();
        transaction.setDebitor(saveDebitor);
        transaction.setKreditor(saveCreditor);
        transaction.setAmount(amount);
        transaction.setDate(timestamp);


        final Transaction tr = transactionRepository.save(transaction);

        return transactionRespMapper.toTransactionResp(tr);

    }
}
//mapStruct