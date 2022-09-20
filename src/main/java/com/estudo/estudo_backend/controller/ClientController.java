package com.estudo.estudo_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.estudo_backend.model.Client;
import com.estudo.estudo_backend.services.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getById(@PathVariable Integer id) {
        return clientService.getById(id);
    }

    @PostMapping
    public Client add(@RequestBody Client client) {
        return clientService.add(client);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        clientService.delete(id);
        return ("Cliente com id = " + id + " foi excluído com sucesso.");
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable Integer id, @RequestBody Client client) {
        return clientService.update(id, client);
    }
}
