package ru.belonogov.bank.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.belonogov.bank.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {


}
