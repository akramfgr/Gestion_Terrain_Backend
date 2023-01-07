package com.example.terrain.controllers;
import com.example.terrain.bean.*;
import com.example.terrain.repositories.*;
import com.example.terrain.services.StorageService;
import com.example.terrain.services.TerrainS;
import com.example.terrain.services.ZoneS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin
@RequestMapping("/terrain")
public class TerrainC {

    @Autowired
    TerrainS terrainS;
    @Autowired
    TerrainR terrainR;
    @Autowired
    ZoneR zoneR;
    @Autowired
    ClubR clubR;

    @Autowired
    private StorageService service;



    @Autowired
    private StorageRepository repo;

    @PostMapping("/add/{zone}/{club}")
    public ResponseEntity<Terrain> addTerrain(@RequestBody Terrain terrain, @PathVariable("zone") int zone,@PathVariable("club") int club ) throws IOException{
        Zone zone1=zoneR.findById(zone).get();
        Club club1=clubR.findById(club).get();

        terrain.setClub(club1);
        terrain.setZone(zone1);

    //    terrain.setUrl("data:image/jpeg;base64,"+ Base64.getEncoder().encodeToString(url.getBytes()));
        return  terrainS.ajouterterrain(terrain);
    }

//    @PostMapping("/add")
//    public Terrain add(@RequestBody Terrain terrain) throws IOException {
//
//        return  terrainR.save(terrain);
//    }

    /// i sould test this with postman
    @PostMapping("/add")
    public Terrain addterrain(@RequestParam("image") MultipartFile file, @RequestParam ("name") String name,@RequestParam ("adresse") String adresse    ,@RequestParam ("longitude") double longitude,@RequestParam ("latitude") double latitude,@RequestParam ("rank") int rank,@RequestParam ("type") String type,@RequestParam ("etat") String etat,@RequestParam ("description") String description,@RequestParam ("typeSal") String typeSal,@RequestParam ("tarif") double tarif,@RequestParam ("zone") int zone,@RequestParam ("club") int club) throws IOException{
        Terrain terrain=new Terrain();
//        images.add(uploadImage);
//        terrain.setImages( images);
        terrain.setNom(name);
        terrain.setAdresse(adresse);
        terrain.setLongitude(longitude);
        terrain.setLatitude(latitude);
        terrain.setRank(rank);
        terrain.setType(type);
        terrain.setEtat(etat);
        terrain.setDescription(description);
        terrain.setTypeSal(typeSal);
        terrain.setTarif(tarif);
        terrain.setZone(zoneR.findById(zone).get());
        terrain.setClub(clubR.findById(club).get());
        terrainS.ajouterterrain(terrain);
        ImageData uploadImage = service.uploadImageTerrain(file,terrain.getId());
        return terrain;
    }
    @GetMapping()
    public ResponseEntity<List<Terrain>> listeDesTerrains(){
        return  terrainS.listeDesTerrains();
    }

    @GetMapping("/find/{id}")
    public Terrain test(@PathVariable("id") int id){
        return  terrainR.findById(id).get();
    }

    @PutMapping("/edit/{id}/{id_zone}/{id_club}")
    public Terrain modifierTerrain(@PathVariable("id") int id,@PathVariable("id_zone") int id_zone,@PathVariable("id_club") int id_club,@RequestBody Terrain t){
        Zone zone=zoneR.findById(id_zone).get();
        Club club=clubR.findById(id_club).get();
        t.setZone(zone);
        t.setClub(club);
        return  terrainR.save(t);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        Terrain exist=terrainR.findById(id).get();
        terrainR.delete(exist);
        return "deleted";

    }

    @GetMapping("/all")
    public List<Terrain> findAll(){

        return terrainR.findAll();
    }  @PostMapping ("/save")
    public void ajouter(@RequestBody Terrain terrain){

        terrainR.save(terrain);
    }


    @GetMapping(value = "/byZone/{id}")
    public List<Terrain> findAllByZone (@PathVariable(required = true) String id) throws ParseException {
        return terrainR.findAllByZone_Nom(id);
    }


}

