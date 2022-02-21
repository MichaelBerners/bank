package ru.belonogov.bank.domain.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.belonogov.bank.domain.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {


}
