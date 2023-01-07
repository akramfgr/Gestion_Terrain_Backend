package com.example.terrain.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String nom;

    @OneToOne()
    @JoinColumn(name = "image_id", referencedColumnName = "id")

    private ImageData imageData;
    @OneToMany(mappedBy="club",cascade = CascadeType.ALL)
    private Set<Terrain> terrains;
    @JsonIgnore
    @OneToMany(mappedBy="club",cascade = CascadeType.ALL)
    private Set<Pack> packs;

    public Club() {
    }

    public Club(String nom) {
        this.nom = nom;
    }

    public Club(int id, ImageData imageData) {
        this.id = id;
        this.imageData = imageData;
    }

    public ImageData getImageData() {
        return imageData;
    }

    public void setImageData(ImageData imageData) {
        this.imageData = imageData;
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

    public void setTerrains(Set<Terrain> terrains) {
        this.terrains = terrains;
    }

    @JsonIgnore
    public Set<Pack> getPacks() {
        return packs;
    }

    public void setPacks(Set<Pack> packs) {
        this.packs = packs;
    }
}
