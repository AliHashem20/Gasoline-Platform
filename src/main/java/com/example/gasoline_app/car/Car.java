package com.example.gasoline_app.car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.gasoline_app.appUser.AppUser;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Car {

    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long car_Id;
    private int plate_number;
    private char symbol;
    private int model;

    @ManyToOne
    @JsonBackReference
    private AppUser user;

    public Car(int plate_number, char symbol, int model) {
        this.plate_number = plate_number;
        this.symbol = symbol;
        this.model = model;
    }

    public Car(){}

    public Long getCar_Id() {
        return car_Id;
    }

    public void setCar_Id(Long car_Id) {
        this.car_Id = car_Id;
    }

    public int getPlate_number() {
        return plate_number;
    }

    public void setPlate_number(int plate_number) {
        this.plate_number = plate_number;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }
    
}
