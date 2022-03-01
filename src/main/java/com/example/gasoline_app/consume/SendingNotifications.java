package com.example.gasoline_app.consume;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.gasoline_app.appUser.AppUser;
import com.example.gasoline_app.appUser.UserRepository;
import com.example.gasoline_app.car.CarRepository;
import com.example.gasoline_app.typeUser.TypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SendingNotifications {

    @Autowired
    private final UserRepository userRepository;

    
    @Autowired
    private final ConsumeRepository consumeRepository;


    @Autowired
    private final TypeRepository typeRepository;

    @Autowired
    private final CarRepository carRepository;

    // public SendingNotifications() {}

    public SendingNotifications(UserRepository u, ConsumeRepository c , TypeRepository t, CarRepository cr) 
    {
        carRepository=cr;
        typeRepository=t;
        consumeRepository=c;
        userRepository = u;
    }

    @Scheduled(cron = "0 0 20 * * 7")
    public void startSending() {
        List<AppUser> l = userRepository.getEligibleUsers();
        userRepository.findAll().stream().filter(user -> user.getIs_eligible() == true).map(map -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now = new Date();
         //   String strDate = sdf.format(now);

            consumeRepository.addCounsumeCar(typeRepository.getWeekAmount(map.getType().getTypeId()), now, carRepository.getCarId(map.getUserID()));
            return 1;
        });

    }
}
