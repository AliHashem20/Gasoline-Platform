package com.example.gasoline_app.typeUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<TypeUser, Long>{
    @Query("Select t.gas_liter_per_week from TypeUser t where t.typeId=?1")
    public int getWeekAmount(Long typeId);
    
}
