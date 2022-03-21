package com.example.demo.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {
    @Bean
    CommandLineRunner commandLineRunner(ClientRepository repository){
        return args -> {
            Client jan = new Client(
                    "Fiołkowa 12",
                    "Jan Nowak");
            Client alex = new Client(
                    "Powstańców 32",
                    "Alex Karl");
            repository.saveAll(List.of(jan, alex));
        };
    }
}
