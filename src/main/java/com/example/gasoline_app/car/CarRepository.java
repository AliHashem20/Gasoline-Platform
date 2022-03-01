package com.example.gasoline_app.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

   public List<Car> findByUserUserID(Long userID); 
   long countByUserUserID(Long userID);

   @Query("select c.car_Id from Car c where c.user=?1")
   public Long getCarId(Long carID);
}
