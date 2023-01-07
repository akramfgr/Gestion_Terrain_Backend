package com.example.terrain.services;

import com.example.terrain.bean.Ville;
import com.example.terrain.repositories.VilleR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleS {

    @Autowired
    VilleR villeR;

    public ResponseEntity<Ville> ajouterVille(Ville v){
        Ville ville= villeR.save(v);
        return new ResponseEntity<>(ville, HttpStatus.OK);
    }

    public ResponseEntity<Ville> modifierVille(Ville v){
         Ville ville=villeR.save(v);
        return new ResponseEntity<>(ville, HttpStatus.OK);
    }
    public ResponseEntity<List<Ville>> listeDesVilles(){
        List<Ville> villes=villeR.findAll();
        return new ResponseEntity<>(villes, HttpStatus.OK);
    }
}
