package com.example.terrain.bean;


import jakarta.persistence.*;

@Entity
public class TerrainReservation {
    @EmbeddedId
    TerrainReservationKey id;

    @ManyToOne
    @MapsId("TerrainId")
    @JoinColumn(name = "terrain_id")
    Terrain terrain;

    @ManyToOne
    @MapsId("ReservationId")
    @JoinColumn(name = "reservation_id")
    Reservation Reservation;


}