package com.example.terrain.controllers;



import com.example.terrain.bean.Club;
import com.example.terrain.bean.Pack;
import com.example.terrain.repositories.ClubR;
import com.example.terrain.repositories.PackR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/pack",consumes = MediaType.APPLICATION_JSON_VALUE)

public class PackC {


    @Autowired
    PackR repo;

    @Autowired
    ClubR repoc;
//
//    @PostMapping("/add/{ville}")
//    public ResponseEntity<Zone> addZone(@RequestBody Zone zone,@PathVariable("ville") int ville){
//        Ville ville1=villeR.findById(ville).get();
//        zone.setVille(ville1);
//        return  zoneS.ajouterZone(zone);
//    }

    @PostMapping("/add/{id}")
    public Pack add(@RequestBody Pack pack,@PathVariable("id") int id ){


        Club club=repoc.findById(id).get();
        pack.setClub(club);
        return  repo.save(pack);
    }


    @GetMapping()
    public List<Pack> listeDesZones(){
        return  repo.findAll();
    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<List<Zone>> listeDesZonesByVille(@PathVariable("id") int id){
//        return  zoneS.listeDesZonesByVille(id);
//    }

//    @PutMapping("/edit/{id}/{id_ville}")
//    public Zone modifierZone(@PathVariable("id") int id,@PathVariable("id_ville") int idv,@RequestBody Zone z){
//        Zone exist=zoneR.findById(id).get();
//        Ville ville=villeR.findById(idv).get();
//        exist.setNom(z.getNom());
//        exist.setVille(ville);
//        return  zoneR.save(exist);
//
//    }

//    @DeleteMapping("/delete/{id}")
//    public String delete(@PathVariable("id") int id){
//        Zone exist=zoneR.findById(id).get();
//        zoneR.delete(exist);
//        return "deleted";
//
//    }


}

