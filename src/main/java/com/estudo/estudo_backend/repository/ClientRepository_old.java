package com.estudo.estudo_backend.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.estudo.estudo_backend.model.Client;
import com.estudo.estudo_backend.model.exception.ResourceNotFoundException;

@Repository
public class ClientRepository_old {
    private List<Client> clients = new ArrayList<Client>();
    private Integer ultimoId = 0;
    
    public List<Client> getAll() {
        return clients;
    }

    public Optional<Client> getById(Integer id) {
        return clients
            .stream()
            .filter(client -> client.getId() == id)
            .findFirst();
    }

    public Client add(Client client) {
        ultimoId++;
        client.setId(ultimoId);
        clients.add(client);
        return client;
    }

    public void delete(Integer id) {
        clients.removeIf(client -> client.getId() == id);
    }

    public Client update(Client client) {
        Optional<Client> foundClient = this.getById(client.getId());
        
        if(foundClient.isEmpty()) {
            throw new ResourceNotFoundException("Cliente não encontrado.");
        }
        this.delete(client.getId());
        clients.add(client);

        return client;

    }
}
