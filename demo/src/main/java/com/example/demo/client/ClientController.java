package com.example.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getStudents() {
        return clientService.getClients();
    }

    @PostMapping
    public void registerNewClient(@RequestBody Client client){clientService.addNewClient(client);}

    @DeleteMapping (path ="{clientId}")
    public void deleteClient(@PathVariable("clientId") Long clientId){
        clientService.deleteClient(clientId);}

    @Transactional
    public void uptateClient(@RequestBody Client client){
        clientService.updateClient(client);
    }
}

