package ru.belonogov.bank.service.implJdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.belonogov.bank.domain.entity.Client;
import ru.belonogov.bank.service.ClientService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@AllArgsConstructor
//@Service
public class ClientServiceImplJdbc implements ClientService {

    JdbcTemplate jdbcTemplate;

    @Override
    public void create(Client client) {

    }

    @Override
    public Client read(Long id) {
        return null;
    }

    @Override
    public List<Client> readAll() {
        return jdbcTemplate.query("select * from clients", new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
                Client client = new Client();

                client.setId(rs.getLong("id"));
                client.setFirstName(rs.getString("first_name"));
                client.setLastName(rs.getString("last_name"));
                client.setEmail(rs.getString("email"));
                client.setPassword(rs.getString("password"));
                return client;
            }
        });
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
