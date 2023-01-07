package com.example.terrain.bean;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Client {
    @Id
    private  int id;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private  String email;
    @Column
    private String password;

    @OneToMany(mappedBy="client",cascade = CascadeType.ALL)
    private Set<Reservation> reservations;
}
