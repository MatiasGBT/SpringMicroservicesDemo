package com.mgbt.motorbikeservice.repositories;

import com.mgbt.motorbikeservice.entities.Motorbike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotorbikeRepository extends JpaRepository<Motorbike, Long> {
    List<Motorbike> findByIdUser(Long idUser);
}
