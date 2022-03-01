package com.example.gasoline_app.appUser;

import java.util.List;

import com.example.gasoline_app.typeUser.TypeUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserController {
    @Autowired
    private final UserService userservice;

    public UserController(UserService u) {
        userservice = u;
    }

    @GetMapping
    public List<AppUser> findAllUsers() {
        return userservice.findAllUsers();
    }

    @GetMapping("/type/{id}/users")
    public List<AppUser> getAllCars(@PathVariable Long id) {
        return userservice.getAllUsers(id);
    }

    @PostMapping("/type/{typeId}/users")
    public String register(@RequestBody AppUser user, @PathVariable Long typeId) {
        // System.out.println(" Hello all "+request.toString());
        user.setType(new TypeUser(typeId,"", 0, 0));
        return userservice.signUpUser(user);

    }

    @PutMapping(path = "/eligible/{id}")
    public void updateEligible(@PathVariable("id") Long id) {
        userservice.updateEligible(id);
    }

    // @PostMapping
    // public String register(@RequestBody AppUser request) {
    //     // System.out.println(" Hello all "+request.toString());
    //     return userservice.signUpUser(request);

    // }
}
