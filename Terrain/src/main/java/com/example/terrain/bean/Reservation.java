package com.example.terrain.bean;

import jakarta.persistence.*;

@Entity
public class Reservation {
    @Id
    private int id;
    @Column
    private String date;
    @Column
    private String etat;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;


}
