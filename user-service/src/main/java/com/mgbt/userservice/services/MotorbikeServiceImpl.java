package com.mgbt.userservice.services;

import com.mgbt.userservice.models.Motorbike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MotorbikeServiceImpl implements MotorbikeService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Motorbike> getByIdUser(Long idUser) {
        return restTemplate.getForObject("http://localhost:8082/api/motorbikes?idUser=" + idUser, List.class);
    }
}
