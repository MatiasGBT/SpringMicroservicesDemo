package com.mgbt.motorbikeservice.controllers;

import com.mgbt.motorbikeservice.entities.Motorbike;
import com.mgbt.motorbikeservice.services.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/motorbikes")
public class MotorbikeController {

    @Autowired
    MotorbikeService motorbikeService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(required = false) Long idUser) {
        if (idUser == null) {
            return new ResponseEntity<>(motorbikeService.getAll(), HttpStatus.OK);
        }
        return new ResponseEntity<>(motorbikeService.getByIdUser(idUser), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(motorbikeService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Motorbike motorbike) {
        return new ResponseEntity<>(motorbikeService.save(motorbike), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Motorbike motorbike) {
        return new ResponseEntity<>(motorbikeService.save(motorbike), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Motorbike motorbike = motorbikeService.findById(id);
        motorbikeService.delete(motorbike);
        return new ResponseEntity<>("Motorbike deleted", HttpStatus.OK);
    }
}
