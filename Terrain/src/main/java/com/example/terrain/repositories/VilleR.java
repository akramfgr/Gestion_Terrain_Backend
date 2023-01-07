package com.example.terrain.repositories;

import com.example.terrain.bean.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleR extends JpaRepository<Ville,Integer> {
}
