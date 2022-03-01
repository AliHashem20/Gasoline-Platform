package com.example.gasoline_app.appUser;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>{
        @Query("SELECT u FROM AppUser u WHERE u.username = ?1")
        public Optional<AppUser> findByUsername(String username);

        public List<AppUser> findByTypeTypeId(Long userID);

        @Query("select count(c) from Car c, AppUser a where c.user=a.userID and a.is_eligible=true")
        public int getEligibleCars(); 

        @Query("Select a from AppUser a where a.is_eligible=true")
        public List<AppUser> getEligibleUsers();
}
