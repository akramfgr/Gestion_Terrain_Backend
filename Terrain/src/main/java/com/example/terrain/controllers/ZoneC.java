package com.example.terrain.controllers;


import com.example.terrain.bean.Ville;
import com.example.terrain.bean.Zone;
import com.example.terrain.repositories.VilleR;
import com.example.terrain.repositories.ZoneR;
import com.example.terrain.services.ZoneS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/zone")
public class ZoneC {

    @Autowired
    ZoneS zoneS;
    @Autowired
    VilleR villeR;
    @Autowired
    ZoneR zoneR;

    @PostMapping("/add/{ville}")
    public ResponseEntity<Zone> addZone(@RequestBody Zone zone,@PathVariable("ville") int ville){
        Ville ville1=villeR.findById(ville).get();
        zone.setVille(ville1);
        return  zoneS.ajouterZone(zone);
    }

    @PostMapping("/add")
    public Zone add(@RequestBody Zone zone){
        return  zoneR.save(zone);
    }


    @GetMapping()
    public ResponseEntity<List<Zone>> listeDesZones(){
        return  zoneS.listeDesZones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Zone>> listeDesZonesByVille(@PathVariable("id") int id){
        return  zoneS.listeDesZonesByVille(id);
    }

    @PutMapping("/edit/{id}/{id_ville}")
    public Zone modifierZone(@PathVariable("id") int id,@PathVariable("id_ville") int idv,@RequestBody Zone z){
        Zone exist=zoneR.findById(id).get();
        Ville ville=villeR.findById(idv).get();
        exist.setNom(z.getNom());
        exist.setVille(ville);
        return  zoneR.save(exist);

    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        Zone exist=zoneR.findById(id).get();
        zoneR.delete(exist);
        return "deleted";

    }

    @GetMapping("/all")
    public List<Zone> findZones(){
        return zoneR.find();
    }
}

