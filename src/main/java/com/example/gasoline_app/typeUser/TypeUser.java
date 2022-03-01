package com.example.gasoline_app.typeUser;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;
    private String typeName;
    private int gas_liter_per_week;
    private int gas_liter_per_month;

    public TypeUser(Long typeId, String typeName, int gas_liter_per_week, int gas_liter_per_month) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.gas_liter_per_week = gas_liter_per_week;
        this.gas_liter_per_month = gas_liter_per_month;
    }

    public TypeUser() {
    }

    public TypeUser(String typeName, int gas_liter_per_week, int gas_liter_per_month) {
        this.typeName = typeName;
        this.gas_liter_per_week = gas_liter_per_week;
        this.gas_liter_per_month = gas_liter_per_month;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getGas_liter_per_week() {
        return gas_liter_per_week;
    }

    public void setGas_liter_per_week(int gas_liter_per_week) {
        this.gas_liter_per_week = gas_liter_per_week;
    }

    public int getGas_liter_per_month() {
        return gas_liter_per_month;
    }

    public void setGas_liter_per_month(int gas_liter_per_month) {
        this.gas_liter_per_month = gas_liter_per_month;
    }

}
