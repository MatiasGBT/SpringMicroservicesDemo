package com.mgbt.motorbikeservice.services;

import com.mgbt.motorbikeservice.entities.Motorbike;
import com.mgbt.motorbikeservice.repositories.MotorbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorbikeServiceImpl implements MotorbikeService{

    @Autowired
    MotorbikeRepository motorbikeRepository;

    @Override
    public List<Motorbike> getAll() {
        return motorbikeRepository.findAll();
    }

    @Override
    public Motorbike findById(Long id) {
        return motorbikeRepository.findById(id).orElse(null);
    }

    @Override
    public Motorbike save(Motorbike motorbike) {
        return motorbikeRepository.save(motorbike);
    }

    @Override
    public void delete(Motorbike motorbike) {
        motorbikeRepository.delete(motorbike);
    }

    @Override
    public List<Motorbike> getByIdUser(Long idUser) {
        return motorbikeRepository.findByIdUser(idUser);
    }
}
