package com.example.demo.repository;

import com.example.demo.entity.SlabRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlabRateRepository extends JpaRepository<SlabRate,Integer> {

//    @Query(value ="select s.rate from slabrate s where s.initial_value >= ?1 and s.final_value <= ?1 Limit 1",nativeQuery = true)
//    @Query(value = "select rate from slabrate where initial_value >= ?1 and final_value <= ?1 Limit 1 ", nativeQuery = true)
//    @Query(value = "select * from slabrate ")
    @Query(value = " select rate from slabrate where final_value = ?1 limit 1 ",nativeQuery = true)
  double findRate(int slabrate);

    @Query(value = "select final_value from slabrate",nativeQuery = true)
    List<Integer> findFinalValue();
}
