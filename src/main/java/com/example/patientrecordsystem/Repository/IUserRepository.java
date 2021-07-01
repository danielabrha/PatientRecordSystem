package com.example.patientrecordsystem.Repository;



import com.example.patientrecordsystem.Domain.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins="http://localhost:4200")
public interface IUserRepository extends JpaRepository<User,Integer> {
}