package com.example.demo.client;

import javax.persistence.*;

@Entity
@Table
public class Client {
    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Long id;
    private String name;
    private String addres;

    public Client(String addres, String name) {
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addres='" + addres + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddres() {
        return addres;
    }

    public Client(Long id, String name, String addres) {
        this.id = id;
        this.name = name;
        this.addres = addres;
    }
}
