package ru.belonogov.bank.domain.response;

import lombok.Data;

@Data
public class ClientResponse {

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}
