package ru.belonogov.bank.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.belonogov.bank.domain.exception.AccountNumberNotFound;
import ru.belonogov.bank.domain.exception.TransactionException;

@RestControllerAdvice
public class TransactionsControllerAdvice {
    @ExceptionHandler(TransactionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String notValid(TransactionException e) {
        return "No money no honey";
    }

    @ExceptionHandler(AccountNumberNotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String notValid(AccountNumberNotFound e) {
        return "Account Number Not Found";
    }

}
