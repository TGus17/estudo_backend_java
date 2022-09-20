package com.estudo.estudo_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.estudo.estudo_backend.model.Client;
import com.estudo.estudo_backend.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getById(Integer id) {
        return clientRepository.getById(id);
    }

    public Client add(Client client) {
        return clientRepository.add(client);
    }

    public void delete(Integer id) {
        clientRepository.delete(id);
    }

    public Client update(Integer id, Client client) {
        client.setId(id);
        return clientRepository.update(client);
    }
}
