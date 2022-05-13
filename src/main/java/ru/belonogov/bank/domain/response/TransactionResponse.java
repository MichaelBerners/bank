package ru.belonogov.bank.domain.response;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class TransactionResponse {

    private Long debitorId;
    private Long creditorId;
    private Long amount;
    private Timestamp date;
}
