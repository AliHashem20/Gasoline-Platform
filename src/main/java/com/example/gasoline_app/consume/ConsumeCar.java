package com.example.gasoline_app.consume;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.gasoline_app.car.Car;

@Entity
public class ConsumeCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consume_id;
    private int amount;
    private Date date;

    @ManyToOne
    // @Column(name = "car_id")
    private Car car;

    public ConsumeCar() {
    }

    public ConsumeCar(int amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public Long getConsume_id() {
        return consume_id;
    }

    public void setConsume_id(Long consume_id) {
        this.consume_id = consume_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
