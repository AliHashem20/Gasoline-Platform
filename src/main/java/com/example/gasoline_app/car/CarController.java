package com.example.gasoline_app.car;

import java.util.List;

import com.example.gasoline_app.appUser.AppUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService service;

    @GetMapping
    public List<Car> findAllCars() {
        return service.findAllCars();
    }

    @GetMapping("/user/{id}/cars")
    public List<Car> getAllCars(@PathVariable Long id) {
        return service.getAllCars(id);
    }

    @PostMapping("/user/{userId}/cars")
    public String register(@RequestBody Car car, @PathVariable Long userId) {
        // System.out.println(" Hello all "+request.toString());
        car.setUser(new AppUser(userId,"", "", "", "", 0,false));
        return service.register(car, userId);

    }


}
