package ru.belonogov.bank.domain;

import lombok.Data;
import ru.belonogov.bank.domain.entity.Account;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Data
public class TransactionResponse {

    private Long debitorId;
    private Long creditorId;
    private Long amount;
    private Timestamp date;
}
