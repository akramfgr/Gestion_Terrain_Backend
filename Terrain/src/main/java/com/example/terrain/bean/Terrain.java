package com.example.terrain.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Terrain implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String nom;
    @Column
    private String adresse;
    @Column
    private double latitude;
    @Column
    private double longitude;
    @Column
    private int rank;
    @Column
    private String type;
    @Column()
    private String etat;
    @Column
    private String description;
    @Column
    private String typeSal;
    @Column
    private double tarif;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="zone_id", nullable=false)
    private Zone zone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="club_id", nullable=false)
    private Club club;
    @OneToMany(mappedBy="terrain",cascade = CascadeType.ALL,fetch = FetchType.EAGER)

    private List<ImageData> images;

    public List<ImageData> getImages() {
        return images;
    }

    public void setImages(List<ImageData> images) {
        this.images = images;
    }

    public Terrain() {
    }

    public Terrain(String nom, String adresse, double latitude, double longitude, int rank, String type, String etat, String description, String typeSal, double tarif) {
        this.nom = nom;
        this.adresse = adresse;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rank = rank;
        this.type = type;
        this.etat = etat;
        this.description = description;
        this.typeSal = typeSal;
        this.tarif = tarif;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeSal() {
        return typeSal;
    }

    public void setTypeSal(String typeSal) {
        this.typeSal = typeSal;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }
    @JsonIgnore
    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }


}
