package com.mgbt.userservice.services;

import com.mgbt.userservice.entities.UserApp;
import com.mgbt.userservice.models.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserApp> getAll();
    UserApp findById(Long id);
    UserApp save(UserApp user);
    void delete(UserApp user);
    List<Car> getCarsByIdUser(Long idUser);
    List<Car> getMotorbikesByIdUser(Long idUser);
}
