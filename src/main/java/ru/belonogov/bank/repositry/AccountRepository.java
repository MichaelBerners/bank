package ru.belonogov.bank.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.belonogov.bank.models.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findAccountByAccountNumber(Long number);

    @Query("select a from Account a where a.accountNumber = :account_number")
    Account readAccountNumber(@Param("account_number") Long accountNumber);





}
