package com.example.gasoline_app.appUser;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.gasoline_app.car.Car;
import com.example.gasoline_app.typeUser.TypeUser;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long userID;
    private String fname;
    private String lname;
    private String username;
    private String password;
    private int phone;
    private Boolean is_eligible = false;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Car> cars;

    @ManyToOne
    private TypeUser type;


    public AppUser(Long userID, String fname, String lname, String username, String password, int phone,
            Boolean is_eligible) {
        this.userID = userID;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.is_eligible = is_eligible;
    }

    public AppUser(String fname, String lname, String username, String password, int phone) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.phone = phone;
      //  this.is_eligible = is_eligible;
    }

    public AppUser(){}

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Boolean getIs_eligible() {
        return is_eligible;
    }

    public void setIs_eligible(Boolean is_eligible) {
        this.is_eligible = is_eligible;
    }

    @JsonManagedReference
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public TypeUser getType() {
        return type;
    }

    public void setType(TypeUser type) {
        this.type = type;
    }
}
