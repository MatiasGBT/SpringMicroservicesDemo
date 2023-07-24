package com.mgbt.carservice.controllers;

import com.mgbt.carservice.entities.Car;
import com.mgbt.carservice.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cars")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(required = false) Long idUser) {
        if (idUser == null) {
            return new ResponseEntity<>(carService.getAll(), HttpStatus.OK);
        }
        return new ResponseEntity<>(carService.getByIdUser(idUser), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(carService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Car car) {
        return new ResponseEntity<>(carService.save(car), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Car car) {
        return new ResponseEntity<>(carService.save(car), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Car car = carService.findById(id);
        carService.delete(car);
        return new ResponseEntity<>("Car deleted", HttpStatus.OK);
    }
}
