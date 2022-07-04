package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name ="slabrate")
public class SlabRate {



    @Id
    @GeneratedValue
    private int id;
    private int initialValue;
    private  int finalValue;
    private double rate;

    public SlabRate() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(int initialValue) {
        this.initialValue = initialValue;
    }

    public int getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(int finalValue) {
        this.finalValue = finalValue;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    public SlabRate(int id, int initialValue, int finalValue, double rate) {
        this.id = id;
        this.initialValue = initialValue;
        this.finalValue = finalValue;
        this.rate = rate;
    }
}
