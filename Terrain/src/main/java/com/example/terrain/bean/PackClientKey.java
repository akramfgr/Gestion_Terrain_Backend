package com.example.terrain.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PackClientKey implements Serializable {
    @Column(name = "client_id")
    int client_id;

    @Column(name = "pack_id")
    int pack_id;
    @Column(name = "date")
    String date;

}
