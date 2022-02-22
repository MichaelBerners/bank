package ru.belonogov.bank.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.belonogov.bank.domain.entity.Client;
import ru.belonogov.bank.domain.repositry.ClientRepository;
import ru.belonogov.bank.service.ClientService;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Override
    public void create(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client read(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public List<Client> readAll(){
        return clientRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName", "lastName"));
    }

    @Override
    public boolean update(Long id, Client client) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
