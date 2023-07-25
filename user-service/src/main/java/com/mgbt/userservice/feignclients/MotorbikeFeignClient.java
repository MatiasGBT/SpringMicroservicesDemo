package com.mgbt.userservice.feignclients;

import com.mgbt.userservice.models.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "motorbike-service", url = "http://localhost:8083")
public interface MotorbikeFeignClient {
    @GetMapping("/api/motorbikes")
    public List<Car> getMotorbikes(@RequestParam(required = false) Long idUser);
}
