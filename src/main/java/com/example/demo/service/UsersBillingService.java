package com.example.demo.service;

import com.example.demo.entity.SlabRate;
import com.example.demo.entity.User;
import com.example.demo.entity.UsersBilling;
import com.example.demo.repository.SlabRateRepository;
import com.example.demo.repository.UsersBillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class UsersBillingService {
    @Autowired
    private UsersBillingRepository repository;
    @Autowired
    private SlabRateRepository slabRateRepository;
    public UsersBilling saveUsersBilling(UsersBilling billing){
        UsersBilling dt= new UsersBilling();
        dt.setCurrent_reading(billing.getCurrent_reading());
        dt.setPrevious_reading(repository.findByCurrentReading());
        dt.setUnit_of_consumption(billing.getCurrent_reading() - dt.getPrevious_reading());

        dt.setDate(LocalDateTime.now());
        dt.setB_Id(billing.getB_Id());
//        double d= Unit_of_consumption(billing.getCurrent_reading() - dt.getPrevious_reading());
        int val2= billing.getCurrent_reading();
        int val1= repository.findByCurrentReading() ;
        int Unit_of_consumption = val2- val1;
        int final_values =0;
        List<Integer> final_value = slabRateRepository.findFinalValue();

        for (int i: final_value) {
            if(Unit_of_consumption<=i){
                final_values = i;
                break;
            }
            else if (Unit_of_consumption>i) {
                final_values = slabRateRepository.maxinitial();
                break;
            }
        }

        double bill = slabRateRepository.findRate(final_values) * dt.getUnit_of_consumption();

//        double price= getFindRate(billing.getCurrent_reading() - dt.getPrevious_reading());
//        double bill = price * Unit_of_consumption;

        dt.setBill(bill);
        User ut=new User();
        Set<UsersBilling> billings = new HashSet<>();
        billings.add(dt);
        ut.setOb(billings);
        dt.setC_id(billing.getC_id());

    return repository.save(dt);
    }
    public List<UsersBilling> saveUsersBilling(List<UsersBilling> billings){
        return repository.saveAll(billings);
    }
    public List<UsersBilling> getReading() {
        return repository.findAll();
    }
    public UsersBilling getReadingById(int id){
          return repository.findById(id).orElse(null);
        }
        public String deleteUsersBilling(int id){
        repository.deleteById(id);
        return "Deleted ! !" + id;
        }

    public List<Double> getUserByPrevious_reading(Integer c_id){
        return repository.findByPreviousReading(c_id);
    }

    public int getUserByCurrentReading() {
        return repository.findByCurrentReading();
            }
//            public int getUnitOfConsumption(){
//        return repository.findUnitOfConsumption();
//            }
    public double getFindRate(int a) {
//        System.out.println(slabRateRepository.findRate(a));
        return slabRateRepository.findRate(a);

    }
    public List<Integer> findFinalValue(){
        return slabRateRepository.findFinalValue();
    }
        public  UsersBilling updateUsersBilling(UsersBilling ub){
        UsersBilling ub1 = repository.findById(ub.getB_Id()).orElse(null);
        ub1.setCurrent_reading(ub.getCurrent_reading());
        ub1.setPrevious_reading(ub.getPrevious_reading());
        ub1.setUnit_of_consumption(ub.getCurrent_reading()-ub.getPrevious_reading());
        ub1.setBill(ub.getBill());
        ub1.setDate(LocalDateTime.now());
        return repository.save(ub1);
        }

}
