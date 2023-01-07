package com.example.terrain.services;

import com.example.terrain.bean.Club;
import com.example.terrain.bean.Ville;
import com.example.terrain.repositories.ClubR;
import com.example.terrain.repositories.VilleR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubS {

    @Autowired
    ClubR clubR;

    public ResponseEntity<Club> ajouterClub(Club club){
        Club club1= clubR.save(club);
        return new ResponseEntity<>(club1, HttpStatus.OK);
    }

    public ResponseEntity<Club> modifierClub(Club c){
        Club club=clubR.save(c);
        return new ResponseEntity<>(club, HttpStatus.OK);
    }

    public ResponseEntity<List<Club>> liste(){
        List<Club> clubs=clubR.findAll();
        return new ResponseEntity<>(clubs, HttpStatus.OK);
    }

}
