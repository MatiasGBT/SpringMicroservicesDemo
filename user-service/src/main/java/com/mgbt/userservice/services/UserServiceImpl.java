package com.mgbt.userservice.services;

import com.mgbt.userservice.entities.User;
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
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
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
