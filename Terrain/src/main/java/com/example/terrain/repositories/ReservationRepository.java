package com.example.terrain.repositories;

import com.example.terrain.bean.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Query(value= "select *  from Reservation ",nativeQuery = true)
    Collection<?> findAllReservations();
}
