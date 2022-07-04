package com.example.demo.controller;

//import com.example.demo.entity.User;
import com.example.demo.entity.User;
import com.example.demo.entity.UsersBilling;
import com.example.demo.service.UsersBillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.apache.coyote.http11.Constants.a;

@RestController
public class UsersBillingController {

    @Autowired
    private UsersBillingService service;

    @GetMapping("/GetReading")
        public List<UsersBilling> findAllUsers() {
        return service.getReading();
    }

    @PostMapping("/CurrentReadings")
        public List<UsersBilling>  addUsers(@PathVariable List<UsersBilling>users){
        return service.saveUsersBilling(users);
    }
    @PostMapping("/addReading")
    public UsersBilling addUsers(@RequestBody UsersBilling user){
        return service.saveUsersBilling(user);
    }
    @DeleteMapping("/delete1/{id}")
    public String deleteUser(@PathVariable int id){
        return service.deleteUsersBilling(id);
    }
    @GetMapping("/PreviousReading/{c_id}")
    public List<Double> PreviousReading(@PathVariable int c_id) {
        return service.getUserByPrevious_reading(c_id);
    }
    @GetMapping("CurrentReading")
    public int CurrentReading(){
        return service.getUserByCurrentReading();
    }
    @GetMapping("/Rate/{a}")
    public double rate(@PathVariable int a){

        return service.getFindRate(a);
    }
@GetMapping("/value")
public List<Integer> value(){
        return service.findFinalValue();
}
    @PutMapping("/update1")
    public UsersBilling updateUsersBilling(@RequestBody UsersBilling users){
        return service.updateUsersBilling(users);
    }
}





