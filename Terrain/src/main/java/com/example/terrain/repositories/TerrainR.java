package com.example.terrain.repositories;

import com.example.terrain.bean.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TerrainR extends JpaRepository<Terrain,Integer> {
    @Query(value= "select longitude,latitude from terrain where zone_id = :id  ",nativeQuery = true)
    Collection<Terrain> findTerrainByZonee(@Param("id") int id);
    @Query("from Terrain v where v.zone.nom= :zone ")
    List<Terrain> findAllByZone_Nom(String zone);



    @Query(value= "select *  from terrain ",nativeQuery = true)
    List<Terrain> findAllTerrains();

}
