package com.example.terrain.repositories;

import com.example.terrain.bean.ImageData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<ImageData,Long> {
    @Query(
            value = "select * from image_data imagedata0_ where id=:id",
            nativeQuery = true)
    ImageData findit(@Param("id") long id);

    Optional<ImageData> findByName(String fileName);
}
