package com.example.terrain.bean;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PackClient   {
    @EmbeddedId
    PackClientKey id;

    @ManyToOne
    @MapsId("ClientId")
    @JoinColumn(name = "client_id")
    Client client;

    @ManyToOne
    @MapsId("PackId")
    @JoinColumn(name = "pack_id")
    Pack pack;


}
