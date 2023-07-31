package com.mgbt.userservice.feignclients;

import com.mgbt.userservice.models.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "car-service")
public interface CarFeignClient {
    @GetMapping("/api/cars")
    public List<Car> getCars(@RequestParam(required = false) Long idUser);
}
