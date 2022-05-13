package ru.belonogov.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.belonogov.bank.domain.request.TransactionRequest;
import ru.belonogov.bank.domain.response.TransactionResponse;
import ru.belonogov.bank.service.TransactionService;
import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    private final TransactionService transactionService;

    @PostMapping
    public TransactionResponse create(@RequestBody @Valid TransactionRequest transactionRequest) {

        final TransactionResponse response = transactionService.transaction(transactionRequest);
        return response;

    }

    /*@GetMapping("/{a}/{b}/{c}")
    void setTransaction(@PathVariable("a") Long debitor,
                        @PathVariable("b") Long creditor,
                        @PathVariable("c") Long amount) throws Exception {

        transactionService.transaction(debitor, creditor, amount);
    }*/
}
