package ru.belonogov.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.belonogov.bank.domain.exception.TransactionException;
import ru.belonogov.bank.service.TransactionService;

@AllArgsConstructor
@RestController
@RequestMapping("/transaction")
public class TransactionsController {

    TransactionService transactionService;

    @GetMapping("/{a}/{b}/{c}")
    void setTransaction(@PathVariable("a") Long debitor,
                        @PathVariable("b") Long creditor,
                        @PathVariable("c") Long amount) throws Exception {

        transactionService.transaction(debitor, creditor, amount);
    }
}
