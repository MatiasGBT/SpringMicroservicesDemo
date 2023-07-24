package com.mgbt.carservice.services;

import com.mgbt.carservice.entities.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<Car> getAll();
    Car findById(Long id);
    Car save(Car car);
    void delete(Car car);
    List<Car> getByIdUser(Long idUser);
}
