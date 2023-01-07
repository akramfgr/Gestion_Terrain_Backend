package com.example.terrain.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
public class Zone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String nom;
    @JsonIgnore
    @OneToMany(mappedBy="zone")
    private Set<Terrain> terrains;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ville_id", nullable=false)
    private Ville city;

    public Zone() {
    }

    public Zone(int id, String nom, Set<Terrain> terrains, Ville ville) {
        this.id = id;
        this.nom = nom;
        this.terrains = terrains;
        this.city = ville;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    @JsonIgnore
    public Set<Terrain> getTerrains() {
        return terrains;
    }
    @JsonIgnore
    public void setTerrains(Set<Terrain> terrains) {
        this.terrains = terrains;
    }

    public Ville getVille() {
        return city;
    }


    public void setVille(Ville ville) {
        this.city = ville;
    }

    public Zone(String nom) {
        this.nom = nom;
    }


}
