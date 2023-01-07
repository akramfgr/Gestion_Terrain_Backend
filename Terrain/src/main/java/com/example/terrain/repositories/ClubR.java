package com.example.terrain.repositories;

import com.example.terrain.bean.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubR extends JpaRepository<Club,Integer> {
}
