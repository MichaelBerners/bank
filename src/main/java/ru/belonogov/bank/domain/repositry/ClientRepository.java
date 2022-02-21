package ru.belonogov.bank.domain.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.belonogov.bank.domain.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {


}
