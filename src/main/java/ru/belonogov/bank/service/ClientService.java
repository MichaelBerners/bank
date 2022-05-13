package ru.belonogov.bank.service;

import ru.belonogov.bank.domain.entity.Client;
import ru.belonogov.bank.domain.request.ClientRequest;
import ru.belonogov.bank.domain.response.ClientResponse;

import java.util.List;

public interface ClientService {

    ClientResponse create(ClientRequest clientRequest);

    Client read(Long id);

    List<Client> readAll();

    boolean update(Long id, Client client);

    boolean delete (Long id);
}
