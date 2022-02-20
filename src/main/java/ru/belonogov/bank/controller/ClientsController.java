package ru.belonogov.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.belonogov.bank.models.Client;
import ru.belonogov.bank.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientsController {

    ClientService clientService;

    @GetMapping()
    public List<Client> readAll(){
        return clientService.readAll();
    }
}
