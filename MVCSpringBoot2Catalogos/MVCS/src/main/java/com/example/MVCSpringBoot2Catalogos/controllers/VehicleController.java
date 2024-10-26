package com.example.MVCSpringBoot2Catalogos.controllers;

import com.example.MVCSpringBoot2Catalogos.entities.BikeEntity;
import com.example.MVCSpringBoot2Catalogos.entities.CarEntity;
import com.example.MVCSpringBoot2Catalogos.services.BikeService;
import com.example.MVCSpringBoot2Catalogos.services.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final CarService carService;
    private final BikeService bikeService;

    public VehicleController(CarService carService, BikeService bikeService) {
        this.carService = carService;
        this.bikeService = bikeService;
    }

    // Endpoints para Autos
    @GetMapping("/cars")
    public List<CarEntity> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/cars/{id}")
    public CarEntity getCarById(@PathVariable UUID id) {
        return carService.getCarById(id).orElse(null);
    }

    @PostMapping("/cars")
    public void addCar(@RequestBody CarEntity car) {
        carService.addCar(car);
    }

    @PutMapping("/cars/{id}")
    public void updateCar(@PathVariable UUID id, @RequestBody CarEntity car) {
        carService.updateCar(id, car);
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable UUID id) {
        carService.deleteCar(id);
    }

    // Endpoints para Motos
    @GetMapping("/bikes")
    public List<BikeEntity> getAllBikes() {
        return bikeService.getAllBikes();
    }

    @GetMapping("/bikes/{id}")
    public BikeEntity getBikeById(@PathVariable UUID id) {
        return bikeService.getBikeById(id).orElse(null);
    }

    @PostMapping("/bikes")
    public void addBike(@RequestBody BikeEntity bike) {
        bikeService.addBike(bike);
    }

    @PutMapping("/bikes/{id}")
    public void updateBike(@PathVariable UUID id, @RequestBody BikeEntity bike) {
        bikeService.updateBike(id, bike);
    }

    @DeleteMapping("/bikes/{id}")
    public void deleteBike(@PathVariable UUID id) {
        bikeService.deleteBike(id);
    }
}