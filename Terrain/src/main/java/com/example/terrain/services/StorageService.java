package com.example.terrain.services;

import com.example.terrain.bean.ImageData;
import com.example.terrain.repositories.StorageRepository;
import com.example.terrain.repositories.TerrainR;
import com.example.terrain.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;
    @Autowired
    private TerrainR terrainR;


    public ImageData uploadImage(MultipartFile file) throws IOException {

        ImageData imageData = repository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());


        if (imageData != null) {
            return imageData;
        }
        return null;
    }

    public ImageData uploadImageTerrain(MultipartFile file,int id) throws IOException {

        ImageData imageData = repository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .terrain(terrainR.findById(id).get())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());


        if (imageData != null) {
            return imageData;
        }
        return null;
    }

    public byte[] downloadImage(Long fileName){
        ImageData dbImageData = repository.findit(fileName);
        byte[] images=ImageUtils.decompressImage(dbImageData.getImageData());
        return images;
    }
}
