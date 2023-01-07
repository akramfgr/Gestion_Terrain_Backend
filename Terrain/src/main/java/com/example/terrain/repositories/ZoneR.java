package com.example.terrain.repositories;

import com.example.terrain.bean.ImageData;
import com.example.terrain.bean.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ZoneR extends JpaRepository<Zone,Integer> {

    @Query(
            value = "select * from zone  where ville_id=:id",
            nativeQuery = true)
    List<Zone> ZonesbyVille(@Param("id") int id);

    @Query(value= "select * from Zone ",nativeQuery = true)
    List<Zone> find();

}
