package com.mgbt.userservice.services;

import com.mgbt.userservice.models.Motorbike;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MotorbikeService {
    List<Motorbike> getByIdUser(Long idUser);
}
