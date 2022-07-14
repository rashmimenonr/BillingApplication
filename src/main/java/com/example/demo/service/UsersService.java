package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user){
        return repository.save(user);
    }
    public List<User>saveUsers(List<User> users){
        return repository.saveAll(users);
    }
    public List<User> getUser(){
        return repository.findAll();
    }
    public User getUserById(int id){
        return repository.findById(id).orElse(null);
    }
    public List<String> getUserByName(){
        return repository.findNames();
    }
//    public String getUserByNames(String name){
//        return repository.findName();
//    }
    public String deleteUser(int c_id){
        repository.deleteById(c_id);
        return "User removed !!" + c_id;
    }
    public User updateUser(User user){
       User existingUser = repository.findById(user.getC_Id()).orElse(null);
       existingUser.setName(user.getName());
       existingUser.setContact((user.getContact()));
       return repository.save(existingUser);
    }

}
