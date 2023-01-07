package com.example.terrain.controllers;


import com.example.terrain.bean.Club;
import com.example.terrain.bean.ImageData;
import com.example.terrain.bean.Ville;
import com.example.terrain.repositories.ClubR;
import com.example.terrain.repositories.StorageRepository;
import com.example.terrain.repositories.VilleR;
import com.example.terrain.services.ClubS;
import com.example.terrain.services.StorageService;
import com.example.terrain.services.VilleS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/club")
public class ClubC {

    @Autowired
    ClubS clubS;
    @Autowired
    private StorageService service;

    @Autowired
    private StorageRepository repo;
    @Autowired
    ClubR clubR;

    @PostMapping("/add")
    public ResponseEntity<Club> addClub(@RequestParam("image") MultipartFile file, @RequestParam ("name") String name) throws IOException{
        Club club=new Club(name);
        ImageData uploadImage = service.uploadImage(file);
        club.setImageData(uploadImage);
        return  clubS.ajouterClub(club);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable Long fileName){
        byte[] imageData=service.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }




    @GetMapping()
    public ResponseEntity<List<Club>> listeDesClubs(){
        return  clubS.liste();
    }

    @PutMapping("/edit/{id}")
    public Club editClub(@PathVariable("id") int id,@RequestBody Club c){
        Club exist=clubR.findById(id).get();
        exist.setNom(c.getNom());
        return  clubR.save(exist);

    }



    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        Club exist=clubR.findById(id).get();
        clubR.delete(exist);
        return "deleted";

    }


}
