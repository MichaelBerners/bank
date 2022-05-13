package ru.belonogov.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.belonogov.bank.domain.request.ClientRequest;
import ru.belonogov.bank.domain.entity.Client;
import ru.belonogov.bank.domain.response.ClientResponse;
import ru.belonogov.bank.service.ClientService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientsController {

    private final ClientService clientService;

    @GetMapping()
    public List<Client> readAll(){
        return clientService.readAll();
    }

    @PostMapping("/create")
    public ClientResponse create (@RequestBody @Valid ClientRequest clientRequest) {

        return clientService.create(clientRequest);
    }
}
