package com.example.terrain.services;

import com.example.terrain.bean.Terrain;
import com.example.terrain.bean.Zone;
import com.example.terrain.repositories.TerrainR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class TerrainS {

    @Autowired
    TerrainR  terrainR;

    public  Terrain getit(int id){
        return  terrainR.findById(id).get();
    }
    public ResponseEntity<Terrain> ajouterterrain(Terrain terrain){
        Terrain terrain1= terrainR.save(terrain);
        return new ResponseEntity<>(terrain1, HttpStatus.OK);
    }

    public ResponseEntity<Terrain> modifierTerrain(Terrain t){
        Terrain terrain=terrainR.save(t);
        return new ResponseEntity<>(terrain, HttpStatus.OK);
    }
    public ResponseEntity<List<Terrain>> listeDesTerrains(){
        List<Terrain> terrains=terrainR.findAll();
        return new ResponseEntity<>(terrains, HttpStatus.OK);
    }
}
