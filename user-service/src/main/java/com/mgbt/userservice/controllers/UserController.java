package com.mgbt.userservice.controllers;

import com.mgbt.userservice.entities.UserApp;
import com.mgbt.userservice.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CircuitBreaker(name = "allServices", fallbackMethod = "fallbackGetById")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("user", userService.findById(id));
        response.put("cars", userService.getCarsByIdUser(id));
        response.put("motorbikes", userService.getMotorbikesByIdUser(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserApp user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody UserApp user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        UserApp user = userService.findById(id);
        userService.delete(user);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }

    private ResponseEntity<?> fallbackGetById(@PathVariable Long id, RuntimeException exception) {
        Map<String, Object> response = new HashMap<>();
        response.put("user", userService.findById(id));
        response.put("message", "At the moment, we are unable to obtain information about the user's vehicles. Please try again later.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
