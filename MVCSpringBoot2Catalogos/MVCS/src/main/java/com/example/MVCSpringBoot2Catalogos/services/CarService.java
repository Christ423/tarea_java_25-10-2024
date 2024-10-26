package com.example.MVCSpringBoot2Catalogos.services;

import com.example.MVCSpringBoot2Catalogos.entities.CarEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarService {
    private final List<CarEntity> cars = new ArrayList<>();

    public CarService() {
        cars.add(new CarEntity(UUID.randomUUID(),"Civic", "Honda", 30000, 10));
        cars.add(new CarEntity(UUID.randomUUID(), "Mustang", "Ford", 50000, 5));
    }

    public List<CarEntity> getAllCars() {
        return cars;
    }

    public Optional<CarEntity> getCarById(UUID id) {
        return cars.stream().filter(car -> car.getId().equals(id)).findFirst();
    }

    public void addCar(CarEntity car) {
        cars.add(car);
    }

    public void updateCar(UUID id, CarEntity updatedCar) {
        getCarById(id).ifPresent(car -> {
            car.setName(updatedCar.getName());
            car.setBrand(updatedCar.getBrand());
            car.setPrice(updatedCar.getPrice());
            car.setStock(updatedCar.getStock());
        });
    }

    public void deleteCar(UUID id) {
        cars.removeIf(car -> car.getId().equals(id));
    }
}
