package ru.belonogov.bank.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.belonogov.bank.domain.entity.Client;
import ru.belonogov.bank.domain.mapper.ClientRespMapper;
import ru.belonogov.bank.domain.repositry.ClientRepository;
import ru.belonogov.bank.domain.request.ClientRequest;
import ru.belonogov.bank.domain.response.ClientResponse;
import ru.belonogov.bank.service.ClientService;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private ClientRespMapper clientRespMapper;

    @Override
    public ClientResponse create(ClientRequest clientRequest) {
        final Client client = new Client();
        client.setFirstName(clientRequest.getFirstName());
        client.setLastName(clientRequest.getLastName());
        client.setEmail(clientRequest.getEmail());
        client.setPassword(clientRequest.getPassword());
        final Client saveClient = clientRepository.save(client);

        return clientRespMapper.toClientResp(saveClient);
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
