package ru.belonogov.bank.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.belonogov.bank.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {


}
