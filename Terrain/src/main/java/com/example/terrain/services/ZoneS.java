package com.example.terrain.services;

import com.example.terrain.bean.Ville;
import com.example.terrain.bean.Zone;
import com.example.terrain.repositories.VilleR;
import com.example.terrain.repositories.ZoneR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneS {

    @Autowired
    ZoneR zoneR;

    public ResponseEntity<Zone> ajouterZone(Zone z){
        Zone zone= zoneR.save(z);
        return new ResponseEntity<>(zone, HttpStatus.OK);
    }

    public ResponseEntity<Zone> modifierZone(Zone z){
        Zone zone=zoneR.save(z);
        return new ResponseEntity<>(zone, HttpStatus.OK);
    }
    public ResponseEntity<List<Zone>> listeDesZones(){
        List<Zone> zones=zoneR.findAll();
        return new ResponseEntity<>(zones, HttpStatus.OK);
    }

    public ResponseEntity<List<Zone>> listeDesZonesByVille(int id){
        List<Zone> zones=zoneR.ZonesbyVille(id);
        return new ResponseEntity<>(zones, HttpStatus.OK);
    }
}