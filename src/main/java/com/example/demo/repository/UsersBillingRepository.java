package com.example.demo.repository;

import com.example.demo.entity.UsersBilling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsersBillingRepository extends JpaRepository<UsersBilling, Integer> {


//    @Query(value = "select  ")
    //    List<UsersBilling> findByName (String name);

    @Query(value = "SELECT Previous_reading FROM user_billing where C_id=?1",nativeQuery = true)

    List<Double> findByPreviousReading(Integer C_id);

    @Query(value =" SELECT MAX(current_reading) FROM user_billing", nativeQuery = true)
     int findByCurrentReading();

//@Query(value = "SELECT unit_of_consumption from user_billing", nativeQuery = true)
//    int findUnitOfConsumption();
}
