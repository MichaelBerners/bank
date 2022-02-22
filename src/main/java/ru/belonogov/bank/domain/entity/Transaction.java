package ru.belonogov.bank.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id_seq")
    @SequenceGenerator(name = "transaction_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "debitor_account_id")
    private Account debitor;

    @ManyToOne
    @JoinColumn(name = "kreditor_account_id")
    private Account kreditor;

    @Column(name = "amount")
    Long amount;

    @Column(name = "date")
    Timestamp date;



}
