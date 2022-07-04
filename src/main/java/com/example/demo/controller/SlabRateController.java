package com.example.demo.controller;

import com.example.demo.entity.SlabRate;
import com.example.demo.service.SlabRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SlabRateController {
    @Autowired

    private SlabRateService slabservice;

    @GetMapping("/slabRate")
    public List<SlabRate> findAllrate(){
        return slabservice.getRate();
    }
}
