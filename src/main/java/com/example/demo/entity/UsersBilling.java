package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name= "user_billing")
public class UsersBilling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int b_id;
    private int current_reading;
    private int previous_reading;
    private int unit_of_consumption;
    private double bill;

    private LocalDateTime date;

//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "b_id")
//    private Set<SlabRate> ob;
    private Integer c_id;
    public UsersBilling() {
    }

    public UsersBilling(int b_id, int current_reading, int previous_reading, int unit_of_consumption, int bill,LocalDateTime date) {
        this.b_id = b_id;
        this.current_reading = current_reading;
        this.previous_reading = previous_reading;
        this.unit_of_consumption = unit_of_consumption;
        this.bill = bill;
        this.date = date;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getB_Id() {
        return b_id;
    }

    public void setB_Id(int b_id) {
        this.b_id = b_id;
    }
    public int getCurrent_reading() {
        return current_reading;
    }

    public void setCurrent_reading(int current_reading) {
        this.current_reading = current_reading;
    }

    public int getPrevious_reading() {
        return previous_reading;
    }

    public void setPrevious_reading(int previous_reading) {
        this.previous_reading = previous_reading;
    }

    public int getUnit_of_consumption() {
        return unit_of_consumption;
    }

    public void setUnit_of_consumption(int unit_of_consumption) {
        this.unit_of_consumption = unit_of_consumption;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public LocalDateTime getDate(){
            return date;
    }

    public void setDate(LocalDateTime date){
        this.date = date;
    }


//    public int getUserByCurrentReading() {
//        return current_reading ;
//    }
}
