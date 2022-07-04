package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UsersService service;

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }
    @PostMapping("/addUsers")
        public List<User> addUsers(@RequestBody List<User>users){
        return service.saveUsers(users);
    }
    @GetMapping("/user")
    public List<User> findAllUser(){
        return service.getUser();
    }
    @GetMapping("Users/{id}")
    public User findUserById(@PathVariable int id){
        return service.getUserById(id);
    }
    @GetMapping("/UsersNames")
    public List<String> findUserByNames (){
        return service.getUserByName();
    }
//    @GetMapping("/UsersName/{name}")
//    public String findUserByName (@PathVariable String name){
//        return service.getUserByNames(name);
//    }
    @PutMapping("/update")
    public User updateUser(@RequestBody User User){
        return service.updateUser(User);
    }
    //    @PutMapping ("/update")
//    public User updateUser(@RequestBody User User ){
//        return service.updateUser(User);
//    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        return service.deleteUser(id);
    }

}

