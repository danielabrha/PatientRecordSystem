package com.example.patientrecordsystem.Repository;



import com.example.patientrecordsystem.Domain.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@Repository
//@CrossOrigin(origins="http://localhost:4200")
public interface IUserRepository extends JpaRepository<User,Integer> {
    //@Query(value="select u from User u where u.userName=:username")
    //public Optional<User> findByuserName( String userName);
}