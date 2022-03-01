package com.example.gasoline_app.consume;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumeRepository extends JpaRepository<ConsumeCar, Long>{



    @Modifying
    @Query(value = "insert into ConsumeCar (amount,date,car) VALUES (:newamount,:newdate,:ncarId)", nativeQuery = true)
    @Transactional
    void addCounsumeCar(@Param("newamount") int newamount, @Param("newdate") Date newdate , @Param("ncarId") Long ncarId);
}
