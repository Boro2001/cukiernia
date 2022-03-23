package com.example.demo.client;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    public List<Client> getClients() {return clientRepository.findAll();}
    public void addNewClient(Client client){
        System.out.println(client);
        Optional<Client> optionalClient = clientRepository .findClientByEmail(client.getEmail());
        if(optionalClient.isPresent()) throw new IllegalStateException("there is actually a e-mail in database like that");
        else clientRepository.save(client);
    }
    public void deleteClient(Long clientId){
        boolean exist = clientRepository.existsById(clientId);
        if(!exist) throw new IllegalStateException("there is no client with id: " + clientId);
        else clientRepository.deleteById(clientId);
    }
    public void updateClient(Client client){
        boolean exist = clientRepository.existsById(client.getId());
        if(!exist) throw new IllegalStateException("there is no client with id: " + client.getId());
        clientRepository.getById(client.getId()).setAddress(client.getAddress());
        clientRepository.getById(client.getId()).setEmail(client.getEmail());
        clientRepository.getById(client.getId()).setName(client.getName());
        clientRepository.getById(client.getId()).setNumber(client.getNumber());

    }
}
