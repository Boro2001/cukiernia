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
                    "Tomcio Paluch",
                    "Fiolkowa 21/42",
                    "banger@gmail.com",
                    "842234243"
                    );
            Client alex = new Client(
                    "Ron pyta ",
                    "falllonska 42/69",
                    "banger@gmail.com",
                    "842234243");
            repository.saveAll(List.of(jan, alex));
        };
    }
}
