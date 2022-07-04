package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name ="user_details")
public class User {
    @Id
    @GeneratedValue
    private int c_id;
    private String name;
    private long contact;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "c_id")
    private Set<UsersBilling> ob;

    public User(int c_id, String name, long contact) {
        this.c_id = c_id;
        this.name = name;
        this.contact = contact;
    }
    public User() {
    }
    public Set<UsersBilling> getOb() {
        return ob;
    }

    public void setOb(Set<UsersBilling> ob) {
        this.ob = ob;
    }
    public int getC_Id() {
        return c_id;
    }
    public void setC_Id(int c_id) {
        this.c_id = c_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getContact() {
        return contact;
    }
    public void setContact(long contact) {
        this.contact = contact;
    }

}
