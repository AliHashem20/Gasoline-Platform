package com.example.gasoline_app.appUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository repository;

    public UserService(UserRepository r) {
        repository = r;
    }

    public String signUpUser(AppUser appUser) {

        if (repository.getEligibleCars() >= 120)
            return "There is no availble space. Thank for your interested in this!";

        boolean userExist = repository.findByUsername(appUser.getUsername())
                .isPresent();
        if (userExist)
            return "user name already exist";
        repository.save(appUser);
        return "created successfully";
    }

    public List<AppUser> getAllUsers(Long id) {
        List<AppUser> users = new ArrayList<>();
        repository.findByTypeTypeId(id)
                .forEach(users::add);
        return users;
    }

    public List<AppUser> findAllUsers() {
        return repository.findAll();
    }

    public void updateEligible(Long id) {
        AppUser appUser = repository.findById(id)
                .orElse(null);

        appUser.setIs_eligible(true);
        repository.save(appUser);
    }
}
