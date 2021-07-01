package com.example.patientrecordsystem.Repository;


import com.example.patientrecordsystem.Domain.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor,Integer> {
}
