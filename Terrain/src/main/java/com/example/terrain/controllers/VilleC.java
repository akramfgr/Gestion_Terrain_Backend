package com.example.terrain.controllers;

import com.example.terrain.bean.Ville;
import com.example.terrain.repositories.VilleR;
import com.example.terrain.services.VilleS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ville")
public class VilleC {

    @Autowired
    VilleS villeService;
    @Autowired
    VilleR villeR;

    @PostMapping("/add")
    public ResponseEntity<Ville> addVille(@RequestBody Ville ville){
        return  villeService.ajouterVille(ville);
    }

    @GetMapping()
    public ResponseEntity<List<Ville>> listeDesVilles(){
        return  villeService.listeDesVilles();
    }

    @PutMapping("/edit/{id}")
    public Ville modifierVille(@PathVariable("id") int id,@RequestBody Ville v){
        Ville exist=villeR.findById(id).get();
        exist.setVille(v.getVille());
        return  villeR.save(exist);

    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        Ville exist=villeR.findById(id).get();
        villeR.delete(exist);
        return "deleted";

    }


}
