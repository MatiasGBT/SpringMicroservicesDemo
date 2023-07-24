package com.mgbt.userservice.controllers;

import com.mgbt.userservice.entities.User;
import com.mgbt.userservice.services.CarService;
import com.mgbt.userservice.services.MotorbikeService;
import com.mgbt.userservice.services.UserService;
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

    @Autowired
    CarService carService;

    @Autowired
    MotorbikeService motorbikeService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("user", userService.findById(id));
        response.put("cars", carService.getByIdUser(id));
        response.put("motorbikes", motorbikeService.getByIdUser(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        User user = userService.findById(id);
        userService.delete(user);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }
}
