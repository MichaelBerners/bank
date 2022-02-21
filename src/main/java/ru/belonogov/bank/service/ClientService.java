package ru.belonogov.bank.service;

import ru.belonogov.bank.domain.entity.Client;
import java.util.List;

public interface ClientService {

    void create(Client client);

    Client read(Long id);

    List<Client> readAll();

    boolean update(Long id, Client client);

    boolean delete (Long id);
}
