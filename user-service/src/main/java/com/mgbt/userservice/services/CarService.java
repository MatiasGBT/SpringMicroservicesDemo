package com.mgbt.userservice.services;

import com.mgbt.userservice.models.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<Car> getByIdUser(Long idUser);
}
