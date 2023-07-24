package com.mgbt.motorbikeservice.services;

import com.mgbt.motorbikeservice.entities.Motorbike;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MotorbikeService {
    List<Motorbike> getAll();
    Motorbike findById(Long id);
    Motorbike save(Motorbike motorbike);
    void delete(Motorbike motorbike);
    List<Motorbike> getByIdUser(Long idUser);
}
