package com.example.gasoline_app.car;

import java.util.ArrayList;
import java.util.List;

import com.example.gasoline_app.appUser.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private final CarRepository carRepository;

    @Autowired 
    private final UserRepository userRepository; 

    public CarService(CarRepository cr, UserRepository ur) {
        carRepository = cr;
        userRepository = ur;
    }

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public List<Car> getAllCars(Long id) {
        List<Car> cars = new ArrayList<>();
        carRepository.findByUserUserID(id)
                .forEach(cars::add);
        return cars;
    }

    public String register(Car request, Long userId) {
        if (carRepository.countByUserUserID(userId) >= 2)
            return "Can't add more than 2 cars to this user";
        boolean userExist = userRepository.findById(userId)
                .isPresent();
        if (!userExist)
            return "User id not found";
        carRepository.save(request);
        return "Assign car successfyully";
    }
}
