package com.mgbt.userservice.services;

import com.mgbt.userservice.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAll();
    User findById(Long id);
    User save(User user);
    void delete(User user);
}
