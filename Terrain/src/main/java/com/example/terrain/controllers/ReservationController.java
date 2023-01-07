package com.example.terrain.controllers;

import com.example.terrain.bean.Reservation;
import com.example.terrain.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/all")
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
    @PostMapping("/save")
    public void ajouter(@RequestBody Reservation reservation){

       reservationRepository.save(reservation);
    }
}
