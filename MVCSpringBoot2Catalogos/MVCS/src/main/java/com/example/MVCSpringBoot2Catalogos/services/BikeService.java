package com.example.MVCSpringBoot2Catalogos.services;

import com.example.MVCSpringBoot2Catalogos.entities.BikeEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BikeService {
    private final List<BikeEntity> bikes = new ArrayList<>();

    public BikeService() {
        bikes.add(new BikeEntity(UUID.randomUUID(),"MT-07", "Deportiva", 7000, 15));
        bikes.add(new BikeEntity(UUID.randomUUID(),"Africa Twin", "Adventure", 15000, 8));
    }

    public List<BikeEntity> getAllBikes() {
        return bikes;
    }

    public Optional<BikeEntity> getBikeById(UUID id) {
        return bikes.stream().filter(bike -> bike.getId().equals(id)).findFirst();
    }

    public void addBike(BikeEntity bike) {
        bikes.add(bike);
    }

    public void updateBike(UUID id, BikeEntity updatedBike) {
        getBikeById(id).ifPresent(bike -> {
            bike.setName(updatedBike.getName());
            bike.setType(updatedBike.getType());
            bike.setPrice(updatedBike.getPrice());
            bike.setStock(updatedBike.getStock());
        });
    }

    public void deleteBike(UUID id) {
        bikes.removeIf(bike -> bike.getId().equals(id));
    }
}