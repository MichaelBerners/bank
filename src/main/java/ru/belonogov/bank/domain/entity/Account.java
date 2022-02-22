package ru.belonogov.bank.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id_seq")
    @SequenceGenerator(name = "account_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "amount")
    private Long amount;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Client client;

    @Column(name = "account_number")
    Long accountNumber;

    //@JsonIgnore
    @OneToMany(mappedBy = "debitor")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<Transaction> debitor = new ArrayList<>();

    //@JsonIgnore
    @OneToMany(mappedBy = "kreditor")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<Transaction> kreditor = new ArrayList<>();
}
