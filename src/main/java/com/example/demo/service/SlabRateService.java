package com.example.demo.service;

import com.example.demo.entity.SlabRate;
import com.example.demo.repository.SlabRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlabRateService {
    @Autowired
    private SlabRateRepository slabRepository ;

    public List<SlabRate> getRate() {
        return slabRepository.findAll();
    }

//    public SlabRate saveRate(SlabRate rate){
//        return slabRepository.save();
//    }
//    public List<SlabRate>saveSlabRate(List<SlabRate> rates){
//        return slabRepository.saveAll(rates);
//    }


//    public  SlabRate getUserById(int id){
//        return slabRepository.findById(id).orElsse(null);
//    }
//    public List<SlabRate> getUser
}
