package com.example.patientrecordsystem.Repository;


import com.example.patientrecordsystem.Domain.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Integer> {
}
