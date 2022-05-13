package ru.belonogov.bank.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.belonogov.bank.domain.entity.Client;
import ru.belonogov.bank.domain.response.ClientResponse;

@Mapper(componentModel = "spring")
public interface ClientRespMapper {

    @Mappings({
            @Mapping(target="firstName", source = "client.firstName"),
            @Mapping(target="lastName", source = "client.lastName"),
            @Mapping(target="email", source = "client.email"),
            @Mapping(target="password", source = "client.password")

            //@Mapping(source = "id", ignore = true)
    })
    ClientResponse toClientResp(Client client);
}
