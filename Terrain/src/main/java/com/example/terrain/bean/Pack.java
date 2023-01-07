package com.example.terrain.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String nom;
    @Column
    private int tarif;
    @Column
    private int nbrDeMatches;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="club_id", nullable=false)
    private Club club;

    public Pack() {
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

    public double getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public int getNbrDeMatches() {
        return nbrDeMatches;
    }

    public void setNbrDeMatches(int nbrDeMatches) {
        this.nbrDeMatches = nbrDeMatches;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
