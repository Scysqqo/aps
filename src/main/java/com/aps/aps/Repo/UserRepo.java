package com.aps.aps.Repo;
import com.aps.aps.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository <User, Long>{
    
}
