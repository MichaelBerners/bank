package ru.belonogov.bank.domain.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String notValid(MethodArgumentNotValidException e) {
        return "Not valid amount";
    }
}
