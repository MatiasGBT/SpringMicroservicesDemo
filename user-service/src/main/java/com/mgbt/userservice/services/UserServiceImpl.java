package com.mgbt.userservice.services;

import com.mgbt.userservice.entities.UserApp;
import com.mgbt.userservice.feignclients.CarFeignClient;
import com.mgbt.userservice.feignclients.MotorbikeFeignClient;
import com.mgbt.userservice.models.Car;
import com.mgbt.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CarFeignClient carFeignClient;

    @Autowired
    MotorbikeFeignClient motorbikeFeignClient;

    @Override
    public List<UserApp> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserApp findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserApp save(UserApp user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(UserApp user) {
        userRepository.delete(user);
    }

    @Override
    public List<Car> getCarsByIdUser(Long idUser) {
        return carFeignClient.getCars(idUser);
    }

    @Override
    public List<Car> getMotorbikesByIdUser(Long idUser) {
        return motorbikeFeignClient.getMotorbikes(idUser);
    }
}
