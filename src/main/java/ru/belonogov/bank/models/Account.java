package ru.belonogov.bank.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter @Setter
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
    private Client client;


    @Column(name = "account_number")
    Long accountNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "debitor")
    List<Transaction> debitor = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "kreditor")
    List<Transaction> kreditor = new ArrayList<>();
}
