package com.mgbt.userservice.services;

import com.mgbt.userservice.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Car> getByIdUser(Long idUser) {
        return restTemplate.getForObject("http://localhost:8081/api/cars?idUser=" + idUser, List.class);
    }
}
